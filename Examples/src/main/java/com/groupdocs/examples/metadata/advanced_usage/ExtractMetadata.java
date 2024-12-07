// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.search.FallsIntoCategorySpecification;
import com.groupdocs.metadata.search.OfTypeSpecification;
import com.groupdocs.metadata.search.Specification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to extract metadata properties by various criteria regardless of the file format.
 */
public class ExtractMetadata {
    public static Path run(Path inputDirectory) {
        final Path outputFolderPath = makeOutputPath("ExtractMetadata");
        try {
            Files.createDirectories(outputFolderPath);
            try (final DirectoryStream<Path> directoryStream = Files.newDirectoryStream(inputDirectory)) {
                for (Path inputFile : directoryStream) {
                    final String inputFileName = inputFile.getFileName().toString();
                    if (!inputFileName.endsWith(".json") && !inputFileName.equals("subtitles.jpg")) {
                        try (Metadata metadata = new Metadata(inputFile.toString())) {
                            final boolean isEncrypted = metadata.getDocumentInfo().isEncrypted();
                            if (metadata.getFileFormat() != FileFormat.Unknown && !isEncrypted) {
                                // Fetch all metadata properties that fall into a particular category
                                IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FallsIntoCategorySpecification(Tags.getContent()));

                                System.out.println("\tThe metadata properties describing some characteristics of the file content: title, keywords, language, etc.");
                                for (MetadataProperty property : properties) {
                                    System.out.printf("\t\tProperty name: %s, Property value: %s%n", property.getName(), property.getValue());
                                }

                                // Fetch all properties having a specific type and value
                                int year = Calendar.getInstance().get(Calendar.YEAR);
                                properties = metadata.findProperties(new OfTypeSpecification(MetadataPropertyType.DateTime).and(new YearMatchSpecification(year)));
                                System.out.println("\tAll datetime properties with the year value equal to the current year");
                                for (MetadataProperty property : properties) {
                                    System.out.printf("\t\tProperty name: %s, Property value: %s%n", property.getName(), property.getValue());
                                }

                                // Fetch all properties whose names match the specified regex
                                Pattern pattern = Pattern.compile("^author|company|(.+date.*)$", Pattern.CASE_INSENSITIVE);
                                properties = metadata.findProperties(new RegexSpecification(pattern));
                                System.out.printf("\tAll properties whose names match the following regex: %s%n", pattern.pattern());
                                for (MetadataProperty property : properties) {
                                    System.out.printf("\t\tProperty name: %s, Property value: %s%n", property.getName(), property.getValue());
                                }

                            } else {
                                System.out.printf("\tSkipping file: '%s', is it encrypted: %s, file format: %s%n", inputFileName, metadata.getDocumentInfo().isEncrypted(), metadata.getFileFormat());
                            }
                        } catch (UnsupportedOperationException e) {
                            FailureRegister.getInstance().registerFailedSample(e); // Register the error but continue
                        }
                    }
                }
            }
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputFolderPath;
    }


    // Define your own specifications to filter metadata properties
    static class YearMatchSpecification extends Specification {
        private int _value;

        public YearMatchSpecification(int year) {
            setValue(year);
        }

        public final int getValue() {
            return _value;
        }

        private void setValue(int value) {
            _value = value;
        }

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            Date date = candidate.getValue().toClass(Date.class);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return getValue() == calendar.get(Calendar.YEAR);
            }
            return false;
        }
    }

    static class RegexSpecification extends Specification {
        private final Pattern _pattern;

        public RegexSpecification(Pattern pattern) {
            this._pattern = pattern;
        }

        @Override
        public boolean isSatisfiedBy(MetadataProperty metadataProperty) {
            Matcher matcher = _pattern.matcher(metadataProperty.getName());
            return matcher.find();
        }
    }
}
