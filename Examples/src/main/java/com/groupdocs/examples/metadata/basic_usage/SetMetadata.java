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

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to set metadata properties by various criteria regardless of the file format.
 */
public class SetMetadata {

    /**
     * Sets metadata properties for files in the specified directory based on certain criteria.
     *
     * @param inputDirectory The path to the input directory containing files to process.
     * @return The path to the output directory where processed files are saved.
     */
    public static Path run(Path inputDirectory) {
        final Path outputFolderPath = makeOutputPath("SetMetadata");
        try {
            Files.createDirectories(outputFolderPath);

            try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(inputDirectory)) {
                for (Path inputFile : directoryStream) {
                    final String inputFileName = inputFile.getFileName().toString();
                    if (!inputFileName.endsWith(".json") && !inputFileName.equals("subtitles.jpg")) {
                        try (Metadata metadata = new Metadata(inputFile.toAbsolutePath().toString())) {
                            final boolean isEncrypted = metadata.getDocumentInfo().isEncrypted();
                            if (metadata.getFileFormat() != FileFormat.Unknown && !isEncrypted) {
                                // This operation is a combination of the AddProperties and UpdateProperties methods.
                                // If an existing property satisfies the predicate its value is updated.
                                // If there is a known property missing in the package that satisfies the predicate it is added to the package.

                                // Set the copyright notice
                                int affected = metadata.setProperties(new ContainsTagSpecification(Tags.getLegal().getCopyright()),
                                        new PropertyValue("Copyright (C) 2011-2021 GroupDocs. All Rights Reserved."));
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
                System.out.println("..sample finished successfully.");
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputFolderPath;
    }
}
