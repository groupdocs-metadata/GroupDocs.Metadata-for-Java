// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.migration.extracting_specific_metadata_packages;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DublinCorePackage;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.Specification;

/**
 * This example demonstrates how to extract Dublin Core metadata regardless of the file format.
 */
public class ExtractPackageUsingCommonApi {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new ExtractPackageUsingCommonApi().new AssignableFromSpecification(DublinCorePackage.class));
            MetadataProperty property = properties.getCount() > 0 ? properties.get_Item(0) : null;

            if (property != null) {
                DublinCorePackage dcPackage = property.getValue().toClass(DublinCorePackage.class);

                System.out.println(dcPackage.getFormat());
                System.out.println(dcPackage.getContributor());
                System.out.println(dcPackage.getCoverage());
                System.out.println(dcPackage.getCreator());
                System.out.println(dcPackage.getSource());
                System.out.println(dcPackage.getDescription());

                // ...
            }
        }
    }

    private class AssignableFromSpecification extends Specification {

        private Class<?> clazz;

        public AssignableFromSpecification(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public boolean isSatisfiedBy(MetadataProperty metadataProperty) {
            return metadataProperty.getValue().getRawValue() != null && clazz.isAssignableFrom(metadataProperty.getValue().getRawValue().getClass());
        }
    }
}
