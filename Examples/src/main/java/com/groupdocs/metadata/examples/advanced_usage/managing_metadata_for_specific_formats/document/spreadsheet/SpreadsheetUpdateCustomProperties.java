// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet demonstrates how to update custom metadata properties in a spreadsheet.
 */
public class SpreadsheetUpdateCustomProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputXls)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().set("customProperty1", "some value");
            root.getDocumentProperties().set("customProperty2", 7);

            // Set a content type property
            root.getDocumentProperties().getContentTypeProperties().set("customContentTypeProperty", "custom value");

            metadata.save(Constants.OutputXls);
        }
    }
}
