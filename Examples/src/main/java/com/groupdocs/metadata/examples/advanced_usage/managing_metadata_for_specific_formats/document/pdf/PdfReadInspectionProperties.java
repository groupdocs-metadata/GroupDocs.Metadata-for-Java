// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to inspect a PDF document.
 */
public class PdfReadInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.SignedPdf)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            if (root.getInspectionPackage().getAnnotations() != null) {
                for (PdfAnnotation annotation : root.getInspectionPackage().getAnnotations()) {
                    System.out.println(annotation.getName());
                    System.out.println(annotation.getText());
                    System.out.println(annotation.getPageNumber());
                }
            }

            if (root.getInspectionPackage().getAttachments() != null) {
                for (PdfAttachment attachment : root.getInspectionPackage().getAttachments()) {
                    System.out.println(attachment.getName());
                    System.out.println(attachment.getMimeType());
                    System.out.println(attachment.getDescription());
                }
            }

            if (root.getInspectionPackage().getBookmarks() != null) {
                for (PdfBookmark bookmark : root.getInspectionPackage().getBookmarks()) {
                    System.out.println(bookmark.getTitle());
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

            if (root.getInspectionPackage().getFields() != null) {
                for (PdfFormField field : root.getInspectionPackage().getFields()) {
                    System.out.println(field.getName());
                    System.out.println(field.getValue());

                    // ...
                }
            }
        }
    }
}
