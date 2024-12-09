// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.search.OfTypeSpecification;
import com.groupdocs.metadata.search.Specification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to update existing metadata properties by various criteria.
 */
public class UpdateMetadata {

    /**
     * Updates existing metadata properties for files in the specified directory based on certain criteria.
     *
     * @param inputDirectory The path to the input directory containing files to process.
     * @return The path to the output directory where processed files are saved.
     */
    public static Path run(Path inputDirectory) {
        final Path outputFolderPath = makeOutputPath("UpdateMetadata");
        try {
            Files.createDirectories(outputFolderPath);

            Date threeDaysAgo = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(3));

            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(inputDirectory)) {
                for (Path inputFile : directoryStream) {
                    final String inputFileName = inputFile.getFileName().toString();
                    if (!inputFileName.endsWith(".json") && !inputFileName.equals("subtitles.jpg")) {
                        try (Metadata metadata = new Metadata(inputFile.toString())) {
                            final boolean isEncrypted = metadata.getDocumentInfo().isEncrypted();
                            if (metadata.getFileFormat() != FileFormat.Unknown && !isEncrypted) {
                                // Update the file creation date/time if the existing value is older than 3 days
                                int affected = metadata.updateProperties(new ContainsTagSpecification(Tags.getTime().getCreated())
                                        .and(new OfTypeSpecification(MetadataPropertyType.DateTime))
                                        .and(new DateBeforeSpecification(threeDaysAgo)), new PropertyValue(new Date()));
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
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputFolderPath;
    }

    /**
     * Define your own specifications to filter metadata properties
     */
    static class DateBeforeSpecification extends Specification {
        private Date _value;

        public DateBeforeSpecification(Date date) {
            setValue(date);
        }

        public final Date getValue() {
            return _value;
        }

        private void setValue(Date value) {
            _value = value;
        }

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            Date date = candidate.getValue().toClass(Date.class);
            if (date != null) {
                return date.before(getValue());
            }
            return false;
        }
    }
}
