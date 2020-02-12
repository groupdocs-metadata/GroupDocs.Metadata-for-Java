// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet demonstrates how to extract built-in metadata properties from a spreadsheet.
 */
public class SpreadsheetReadBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getAuthor());
            System.out.println(root.getDocumentProperties().getCreatedTime());
            System.out.println(root.getDocumentProperties().getCompany());
            System.out.println(root.getDocumentProperties().getCategory());
            System.out.println(root.getDocumentProperties().getKeywords());
            System.out.println(root.getDocumentProperties().getLanguage());
            System.out.println(root.getDocumentProperties().getContentType());

            // ... 
        }
    }
}
