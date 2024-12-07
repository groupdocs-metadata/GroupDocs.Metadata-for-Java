// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;

/**
 * This example demonstrates how to inspect a PDF document.
 */
public class PdfReadInspectionProperties {
    public static PdfRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PdfRootPackage root = metadata.getRootPackageGeneric();
            if (root.getInspectionPackage().getAnnotations() != null) {
                for (PdfAnnotation annotation : root.getInspectionPackage().getAnnotations()) {
                    System.out.printf("\tName: %s%n", annotation.getName());
                    final String annotationText = annotation.getText();
                    if (annotationText != null) {
                        System.out.printf("\tText: %s%n", annotationText.substring(0, Math.min(annotationText.length(), 50)) + "...");
                    }
                    System.out.printf("\tPage Number: %d%n", annotation.getPageNumber());
                }
            }
            if (root.getInspectionPackage().getAttachments() != null) {
                for (PdfAttachment attachment : root.getInspectionPackage().getAttachments()) {
                    System.out.printf("\tName: %s%n", attachment.getName());
                    System.out.printf("\tMIME Type: %s%n", attachment.getMimeType());
                    System.out.printf("\tDescription: %s%n", attachment.getDescription());
                }
            }
            if (root.getInspectionPackage().getBookmarks() != null) {
                for (PdfBookmark bookmark : root.getInspectionPackage().getBookmarks()) {
                    System.out.printf("\tTitle: %s%n", bookmark.getTitle());
                }
            }
            if (root.getInspectionPackage().getDigitalSignatures() != null) {
                for (DigitalSignature signature : root.getInspectionPackage().getDigitalSignatures()) {
                    System.out.printf("\tCertificate Subject: %s%n", signature.getCertificateSubject());
                    System.out.printf("\tComments: %s%n", signature.getComments());
                    System.out.printf("\tSign Time: %s%n", signature.getSignTime());
                }
            }
            if (root.getInspectionPackage().getFields() != null) {
                for (PdfFormField field : root.getInspectionPackage().getFields()) {
                    System.out.printf("\tName: %s%n", field.getName());
                    System.out.printf("\tValue: %s%n", field.getValue());
                }
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
