// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.search.FallsIntoCategorySpecification;
import com.groupdocs.metadata.search.WithNameSpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to remove metadata properties by various criteria.
 */
public class RemoveMetadata {

    /**
     * Removes metadata properties from files in the specified directory based on certain criteria.
     *
     * @param inputDirectory The path to the input directory containing files to process.
     * @return The path to the output directory where processed files are saved.
     */
    public static Path run(Path inputDirectory) {
        final Path outputFolderPath = makeOutputPath("RemoveMetadata");
        try {
            Files.createDirectories(outputFolderPath);

            try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(inputDirectory)) {
                for (Path inputFile : directoryStream) {
                    final String inputFileName = inputFile.getFileName().toString();

                    if (!inputFileName.endsWith(".json") && !inputFileName.endsWith(".dae") && !inputFileName.equals("subtitles.jpg")) {
                        try (Metadata metadata = new Metadata(inputFile.toString())) {
                            final boolean isEncrypted = metadata.getDocumentInfo().isEncrypted();
                            if (metadata.getFileFormat() != FileFormat.Unknown && !isEncrypted) {
                                int affected = metadata.removeProperties(new FallsIntoCategorySpecification(Tags.getPerson())
                                        .or(new WithNameSpecification("CustomProperty")));
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
