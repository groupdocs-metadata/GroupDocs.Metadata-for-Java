// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows hot to remove inspection properties from a spreadsheet.
 */
public class SpreadsheetUpdateInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            root.getInspectionPackage().clearComments();
            root.getInspectionPackage().clearDigitalSignatures();
            root.getInspectionPackage().clearHiddenSheets();

            metadata.save(Constants.OutputXlsx);
        }
    }
}
