// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to remove the inspection properties in a PDF document.
 */
public class PdfUpdateInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.SignedPdf)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            root.getInspectionPackage().clearAnnotations();
            root.getInspectionPackage().clearAttachments();
            root.getInspectionPackage().clearFields();
            root.getInspectionPackage().clearBookmarks();
            root.getInspectionPackage().clearDigitalSignatures();

            metadata.save(Constants.OutputPdf);
        }
    }
}
