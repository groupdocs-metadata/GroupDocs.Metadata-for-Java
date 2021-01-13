// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet demonstrates how to update custom metadata properties in a PDF document.
 */
public class PdfUpdateCustomProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPdf)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().set("customProperty1", "some value");

            metadata.save(Constants.OutputPdf);
        }
    }
}
