// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.SpreadsheetContentTypeProperty;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

/**
 * This code snippet demonstrates how to extract custom metadata properties from a spreadsheet.
 */
public class SpreadsheetReadCustomProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputXls)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());

            for (MetadataProperty property : customProperties) {
                System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
            }

            // Extract only content type properties if required
            for (SpreadsheetContentTypeProperty contentTypeProperty : root.getDocumentProperties().getContentTypeProperties().toList()) {
                System.out.println(String.format("%s, %s = %s", contentTypeProperty.getSpreadsheetPropertyType(), contentTypeProperty.getName(), contentTypeProperty.getSpreadsheetPropertyValue()));
            }
        }
    }
}
