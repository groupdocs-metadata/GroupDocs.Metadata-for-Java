// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.extracting_property_values;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.AnySpecification;

import java.util.Date;

/**
 * This code snippet demonstrates how to extract the property value using the Type property.
 */
public class ExtractUsingType {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            // Fetch all metadata properties from the file
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());
            for (MetadataProperty property : properties) {
                // Process String and DateTime properties only
                if (property.getValue().getType() == MetadataPropertyType.String) {
                    System.out.println(property.getValue().toClass(String.class));
                } else if (property.getValue().getType() == MetadataPropertyType.DateTime) {
                    System.out.println(property.getValue().toClass(Date.class));
                }
            }
        }
    }
}
