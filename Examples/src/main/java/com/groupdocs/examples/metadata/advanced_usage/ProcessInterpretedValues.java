// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.search.Specification;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to use interpreted property values.
 */
public class ProcessInterpretedValues {
    public static void run(Path inputDirectory) {
        final Path outputFolderPath = makeOutputPath("ProcessInterpretedValues");
        try {
            Files.createDirectories(outputFolderPath);

            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(inputDirectory)) {
                for (Path inputFile : directoryStream) {
                    final String inputFileName = inputFile.getFileName().toString();
                    if (!inputFile.toString().endsWith(".json") && !inputFileName.equals("subtitles.jpg")) {
                        try (Metadata metadata = new Metadata(inputFile.toString())) {
                            final boolean isEncrypted = metadata.getDocumentInfo().isEncrypted();
                            if (metadata.getFileFormat() != FileFormat.Unknown && !isEncrypted) {
                                IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new InterpretedValueIsNotNullSpecification());
                                for (MetadataProperty property : properties) {
                                    System.out.printf("\tFile: '%s', Property: '%s', Raw Value: '%s', Interpreted Value: '%s'%n", inputFileName, property.getName(), property.getValue().getRawValue(), property.getInterpretedValue().getRawValue());
                                }
                            } else {
                                System.out.printf("\tSkipping file: '%s', is it encrypted: %s, file format: %s%n", inputFileName, isEncrypted, metadata.getFileFormat());
                            }
                        } catch (UnsupportedOperationException e) {
                            FailureRegister.getInstance().registerFailedSample(e); // Register the error but continue
                        }
                    }
                }
            }
            System.out.println("..sample finished successfully.");
        } catch (IOException e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
    }


    static class InterpretedValueIsNotNullSpecification extends Specification {
        @Override
        public boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate.getInterpretedValue() != null;
        }
    }
}
