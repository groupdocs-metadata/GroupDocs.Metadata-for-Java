// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.migration.exporting_metadata_properties;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.AnySpecification;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

/**
 * This code sample demonstrates how to export all metadata properties to a CSV file.
 */
public class ExportPropertiesToCsv {
    public static void run() throws FileNotFoundException {
        try (Metadata metadata = new Metadata(Constants.InputEml)) {
            // We use a predicate that extracts all metadata properties
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());
            String delimiter = ";";
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("Name%sValue", delimiter));
            builder.append("\n");
            for (MetadataProperty property : properties) {
                builder.append(String.format("\"%s\"%s\"%s\"", property.getName(), delimiter, FormatValue(property.getValue())));
                builder.append("\n");
            }

            try (PrintWriter out = new PrintWriter(Constants.OutputCsv)) {
                out.println(builder.toString());
            }
        }
    }

    private static String FormatValue(PropertyValue propertyValue) {
        if (propertyValue == null || propertyValue.getRawValue() == null) {
            return null;
        }

        Object value = propertyValue.getRawValue();

        StringBuilder result = new StringBuilder();
        if (value.getClass().isArray()) {
            int arrayMaxLength = 20;
            String arrayStartCharacter = "[";
            String arrayEndCharacter = "]";

            int length = Array.getLength(value);
            if (length > 0) {
                result.append(arrayStartCharacter);
                for (int index = 0; index < length; index++) {
                    Object item = Array.get(value, index);
                    ;
                    result.append(String.format("%s, ", item));
                    if (index > arrayMaxLength) {
                        result.append("...");
                        break;
                    }
                }
                result.delete(result.length() - 2, result.length());
                result.append(arrayEndCharacter);
            }
        } else {
            result.append(value);
        }

        replaceAll(result, "\"", "\"\"");
        return result.toString();
    }

    private static void replaceAll(StringBuilder builder, String from, String to) {
        int index = builder.indexOf(from);
        while (index != -1) {
            builder.replace(index, index + from.length(), to);
            index += to.length();
            index = builder.indexOf(from, index);
        }
    }
}
