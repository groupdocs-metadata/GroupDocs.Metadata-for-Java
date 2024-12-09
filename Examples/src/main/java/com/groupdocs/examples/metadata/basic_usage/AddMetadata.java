// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to add missing metadata properties to files.
 */
public class AddMetadata {

    /**
     * Adds missing metadata properties to each file in the input directory.
     *
     * @param inputDirectory The path to the directory containing the files to be processed.
     * @return The path to the output folder where the modified files are saved.
     */
    public static Path run(Path inputDirectory) {
        System.out.println("Running sample: AddMetadata..");
        final Path outputFolderPath = makeOutputPath("AddMetadata");
        try {
            Files.createDirectories(outputFolderPath);
            try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(inputDirectory)) {
                for (Path inputFile : directoryStream) {
                    final String inputFileName = inputFile.getFileName().toString();

                    if (!inputFileName.endsWith(".json") && !inputFileName.endsWith(".zip") && !inputFileName.equals("subtitles.jpg")) {
                        try (Metadata metadata = new Metadata(inputFile.toString())) {
                            final boolean isEncrypted = metadata.getDocumentInfo().isEncrypted();
                            if (metadata.getFileFormat() != FileFormat.Unknown && !isEncrypted) {
                                // Add a property containing the file last printing date if it's missing
                                // Note that the property will be added to metadata packages that satisfy the following criteria:
                                // 1) Only existing metadata packages will be affected. No new packages are added during this operation
                                // 2) There should be a known metadata property in the package structure that fits the search condition but is actually missing in the package.
                                // All properties supported by a certain package are usually defined in the specification of a particular metadata standard
                                int affected = metadata.addProperties(new ContainsTagSpecification(Tags.getTime().getPrinted()), new PropertyValue(new Date()));
                                System.out.printf("\tFile name: '%s', affected properties: %s%n", inputFileName, affected);

                                metadata.save(outputFolderPath.resolve(inputFileName).toString());
                            } else {
                                System.out.printf("\tSkipping file: '%s', is it encrypted: %s, file format: %s%n", inputFileName, isEncrypted, metadata.getFileFormat());
                            }
                        } catch (UnsupportedOperationException e) {
                            FailureRegister.getInstance().registerFailedSample(e); // Register the error but continue
                        }
                    }
                }
                System.out.println("..sample finished successfully.\n");
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputFolderPath;
    }
}
