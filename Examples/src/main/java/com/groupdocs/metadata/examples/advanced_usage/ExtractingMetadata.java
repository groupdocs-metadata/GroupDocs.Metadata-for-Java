// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.FallsIntoCategorySpecification;
import com.groupdocs.metadata.search.OfTypeSpecification;
import com.groupdocs.metadata.search.Specification;
import com.groupdocs.metadata.tagging.Tags;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

/**
 * This example demonstrates how to extract metadata properties by various criteria regardless of the file format.
 */
public class ExtractingMetadata {
    public static void run() {
        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles()) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());

                    // Fetch all metadata properties that fall into a particular category
                    IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FallsIntoCategorySpecification(Tags.getContent()));
                    System.out.println("The metadata properties describing some characteristics of the file content: title, keywords, language, etc.");
                    for (MetadataProperty property : properties) {
                        System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
                    }

                    // Fetch all properties having a specific type and value
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    properties = metadata.findProperties(new OfTypeSpecification(MetadataPropertyType.DateTime).and(new ExtractingMetadata().new YearMatchSpecification(year)));
                    System.out.println("All datetime properties with the year value equal to the current year");
                    for (MetadataProperty property : properties) {
                        System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
                    }
                }
            }
        }
    }

    // Define your own specifications to filter metadata properties
    public class YearMatchSpecification extends Specification {
        public YearMatchSpecification(int year) {
            setValue(year);
        }

        public final int getValue() {
            return auto_Value;
        }

        private void setValue(int value) {
            auto_Value = value;
        }

        private int auto_Value;

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
}
