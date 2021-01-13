// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.basic_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.search.OfTypeSpecification;
import com.groupdocs.metadata.search.Specification;
import com.groupdocs.metadata.tagging.Tags;

/**
 * This example demonstrates how to remove specific metadata properties using various criteria.
 */
public class RemoveMetadataProperties {
    public static void run() {
        // Constants.InputDocx is an absolute or relative path to your document. Ex: @"C:\Docs\source.docx"
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {

            // Remove all the properties satisfying the predicate:
            // property contains the name of the document author OR
            // it refers to the last editor OR
            // the property value is a string that is equal to the given string "John" (to remove any mentions of John from the detected metadata)
            int affected = metadata.removeProperties(
                    new ContainsTagSpecification(Tags.getPerson().getCreator()).or(
                            new ContainsTagSpecification(Tags.getPerson().getEditor())).or(
                            new OfTypeSpecification(MetadataPropertyType.String).and(new RemoveMetadataProperties().new WithValueSpecification("John"))));

            System.out.println(String.format("Properties removed: %s", affected));

            metadata.save(Constants.OutputDocx);
        }
    }

    // Define your own specifications to filter metadata properties
    public class WithValueSpecification extends Specification {
        public WithValueSpecification(Object value) {
            setValue(value);
        }

        public final Object getValue() {
            return auto_Value;
        }

        private void setValue(Object value) {
            auto_Value = value;
        }

        private Object auto_Value;

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate.getValue().getRawValue().equals(getValue());
        }
    }
}
