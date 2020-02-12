// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.basic_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

/**
 * This example demonstrates how to search for specific metadata properties using tags.
 */
public class FindMetadataProperties {
    public static void run() {

        // Constants.InputPptx is an absolute or relative path to your document. Ex: @"C:\Docs\source.pptx"
        try (Metadata metadata = new Metadata(Constants.InputPptx)) {

            // Fetch all the properties satisfying the predicate:
            // property contains the name of the last document editor OR the date/time the document was last modified
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(
                    new ContainsTagSpecification(Tags.getPerson().getEditor()).or(new ContainsTagSpecification(Tags.getTime().getModified())));
            for (MetadataProperty property : properties) {
                System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
            }
        }
    }
}
