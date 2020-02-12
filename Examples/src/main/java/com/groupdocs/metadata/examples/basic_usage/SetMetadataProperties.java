// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.basic_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.util.Date;

/**
 * This example demonstrates how to set specific metadata properties using different criteria.
 */
public class SetMetadataProperties {
    public static void run() {
        // Constants.InputVsdx is an absolute or relative path to your document. Ex: @"C:\Docs\source.vsdx"
        try (Metadata metadata = new Metadata(Constants.InputVsdx)) {
            // Set the value of each property that satisfies the predicate:
            // property contains the date/time the document was created OR modified
            int affected = metadata.setProperties(
                    new ContainsTagSpecification(Tags.getTime().getCreated()).or(new ContainsTagSpecification(Tags.getTime().getModified())),
                    new PropertyValue(new Date()));

            System.out.println(String.format("Properties set: %s", affected));

            metadata.save(Constants.OutputVsdx);
        }
    }
}
