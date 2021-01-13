// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DigitalSignature;
import com.groupdocs.metadata.core.SpreadsheetComment;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.core.SpreadsheetSheet;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet shows how to inspect a spreadsheet document.
 */
public class SpreadsheetReadInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputXls)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            if (root.getInspectionPackage().getComments() != null) {
                for (SpreadsheetComment comment : root.getInspectionPackage().getComments()) {
                    System.out.println(comment.getAuthor());
                    System.out.println(comment.getText());
                    System.out.println(comment.getSheetNumber());
                    System.out.println(comment.getRow());
                    System.out.println(comment.getColumn());
                }
            }

            if (root.getInspectionPackage().getDigitalSignatures() != null) {
                for (DigitalSignature signature : root.getInspectionPackage().getDigitalSignatures()) {
                    System.out.println(signature.getCertificateSubject());
                    System.out.println(signature.getComments());
                    System.out.println(signature.getSignTime());

                    // ...
                }
            }

            if (root.getInspectionPackage().getHiddenSheets() != null) {
                for (SpreadsheetSheet sheet : root.getInspectionPackage().getHiddenSheets()) {
                    System.out.println(sheet.getName());
                    System.out.println(sheet.getNumber());
                }
            }
        }
    }
}
