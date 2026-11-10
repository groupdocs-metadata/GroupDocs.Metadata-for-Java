// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.migration.comparing_metadata_properties;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyEqualityComparer;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

/**
 * This code snippet demonstrates how to get the difference of two collections of properties extracted from different files.
 */
public class GetDifferenceOfDocumentProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Migration] # GetDifferenceOfDocumentProperties : How to get the difference of two collections of properties extracted from different files.\n");
        // The specification to extract metadata properties we want to compare
        // In this code sample we retrieve built-in document properties
        ContainsTagSpecification specification = new ContainsTagSpecification(Tags.getDocument().getBuiltIn());

        try (Metadata metadata1 = new Metadata(Constants.InputDoc);
             Metadata metadata2 = new Metadata(Constants.InputDocx)) {
            IReadOnlyList<MetadataProperty> properties1 = metadata1.findProperties(specification);
            IReadOnlyList<MetadataProperty> properties2 = metadata2.findProperties(specification);

            // You can implement your own equality comparer for metadata properties
            // In this code sample, we just use the one that worked in previous versions of GroupDocs.Metadata
            MetadataPropertyEqualityComparer comparer = new MetadataPropertyEqualityComparer();
            for (MetadataProperty property : properties1) {
                boolean found = false;
                for (MetadataProperty other : properties2) {
                    if (comparer.equals(property, other)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
                }
            }
        }
    }
}
