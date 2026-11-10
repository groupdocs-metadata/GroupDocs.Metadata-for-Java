// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.migration.comparing_metadata_properties;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyEqualityComparer;
import com.groupdocs.metadata.core.TiffTag;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.Specification;

/**
 * This code snippet demonstrates how to get the intersection of two collections of properties extracted from different files.
 */
public class GetIntersectionOfExifProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Migration] # GetIntersectionOfExifProperties : How to get the intersection of two collections of properties extracted from different files.\n");
        // The specification to extract metadata properties we want to compare
        // In this code sample we retrieve TIFF/EXIF tags
        Specification specification = new Specification() {
            @Override
            public boolean isSatisfiedBy(MetadataProperty property) {
                return property instanceof TiffTag;
            }
        };

        try (Metadata metadata1 = new Metadata(Constants.JpegWithExif);
             Metadata metadata2 = new Metadata(Constants.TiffWithExif)) {
            IReadOnlyList<MetadataProperty> properties1 = metadata1.findProperties(specification);
            IReadOnlyList<MetadataProperty> properties2 = metadata2.findProperties(specification);

            // You can implement your own equality comparer for metadata properties
            // In this code sample, we just use the one that worked in previous versions of GroupDocs.Metadata
            MetadataPropertyEqualityComparer comparer = new MetadataPropertyEqualityComparer();
            for (MetadataProperty property : properties1) {
                for (MetadataProperty other : properties2) {
                    if (comparer.equals(property, other)) {
                        System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
                        break;
                    }
                }
            }
        }
    }
}
