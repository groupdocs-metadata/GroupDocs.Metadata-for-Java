// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to detect the exact type of a loaded spreadsheet and extract some additional file format information.
 */
public class SpreadsheetReadFileFormatProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getSpreadsheetType().getFileFormat());
            System.out.println(root.getSpreadsheetType().getSpreadsheetFormat());
            System.out.println(root.getSpreadsheetType().getMimeType());
            System.out.println(root.getSpreadsheetType().getExtension());
        }
    }
}
