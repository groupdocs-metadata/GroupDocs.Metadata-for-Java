// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.migration.using_custom_replace_handler;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.Specification;

/**
 * This code sample demonstrates how to update metadata property values using a custom filter.
 */
public class UpdatePropertyValue {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            int affected = metadata.updateProperties(new UpdatePropertyValue().new CustomNameComparerSpecification("author"), new PropertyValue("Jack London"));

            System.out.println(affected);

            metadata.save(Constants.OutputDocx);
        }
    }

    private class CustomNameComparerSpecification extends Specification {

        private String name;

        public CustomNameComparerSpecification(String name) {
            this.name = name;
        }

        @Override
        public boolean isSatisfiedBy(MetadataProperty metadataProperty) {
            return metadataProperty.getName().equalsIgnoreCase(name);
        }
    }
}
