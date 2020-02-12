// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.migration.working_with_regular_expressions;


import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.Specification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This code snippet demonstrates how to search for metadata properties using a regular expression.
 */
public class FindPropertiesByRegex {
    public static void run() {
        Pattern pattern = Pattern.compile("author|company", Pattern.CASE_INSENSITIVE);

        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            // This method searches for properties across all metadata packages and works with all supported formats
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FindPropertiesByRegex().new RegexSpecification(pattern));

            for (MetadataProperty property : properties) {
                System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
            }
        }
    }

    public class RegexSpecification extends Specification {
        private Pattern pattern;

        public RegexSpecification(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override
        public boolean isSatisfiedBy(MetadataProperty metadataProperty) {
            Matcher matcher = pattern.matcher(metadataProperty.getName());
            return matcher.find();
        }
    }
}
