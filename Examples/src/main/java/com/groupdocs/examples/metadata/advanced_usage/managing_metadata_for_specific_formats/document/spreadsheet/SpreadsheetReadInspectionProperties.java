// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DigitalSignature;
import com.groupdocs.metadata.core.SpreadsheetComment;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.core.SpreadsheetSheet;

import java.nio.file.Path;

/**
 * This code snippet shows how to inspect a spreadsheet document.
 */
public class SpreadsheetReadInspectionProperties {
    public static SpreadsheetRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
            if (root.getInspectionPackage().getComments() != null) {
                for (SpreadsheetComment comment : root.getInspectionPackage().getComments()) {
                    System.out.printf("\tAuthor: %s%n", comment.getAuthor());
                    final String commentText = comment.getText();
                    System.out.printf("\tText: %s%n", commentText.substring(0, Math.min(commentText.length(), 50)) + "...");
                    System.out.printf("\tSheet Number: %d%n", comment.getSheetNumber());
                    System.out.printf("\tRow: %d%n", comment.getRow());
                    System.out.printf("\tColumn: %d%n", comment.getColumn());
                }
            } else {
                System.out.println("\tNo comments found.");
            }
            if (root.getInspectionPackage().getDigitalSignatures() != null) {
                for (DigitalSignature signature : root.getInspectionPackage().getDigitalSignatures()) {
                    System.out.printf("\tCertificate Subject: %s%n", signature.getCertificateSubject());
                    System.out.printf("\tComments: %s%n", signature.getComments());
                    System.out.printf("\tSign Time: %s%n", signature.getSignTime());
                }
            } else {
                System.out.println("\tNo digital signatures found.");
            }
            if (root.getInspectionPackage().getHiddenSheets() != null) {
                for (SpreadsheetSheet sheet : root.getInspectionPackage().getHiddenSheets()) {
                    System.out.printf("\tName: %s%n", sheet.getName());
                    System.out.printf("\tNumber: %d%n", sheet.getNumber());
                }
            } else {
                System.out.println("\tNo hidden sheets found.");
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
