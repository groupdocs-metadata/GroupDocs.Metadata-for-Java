// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.migration.working_with_regular_expressions;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.Specification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This code snippet demonstrates how to update metadata properties using a regular expression.
 */
public class UpdatePropertiesByRegex {
    public static void run() {
        Pattern pattern = Pattern.compile("^author|company$", Pattern.CASE_INSENSITIVE);
        PropertyValue replaceValue = new PropertyValue("Aspose");

        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            // This method updates writable properties across all metadata packages and works with all supported formats
            metadata.updateProperties(new UpdatePropertiesByRegex().new RegexSpecification(pattern), replaceValue);

            metadata.save(Constants.OutputDocx);
        }
    }

    private class RegexSpecification extends Specification {
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
