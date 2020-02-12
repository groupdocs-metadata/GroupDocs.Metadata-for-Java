// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This code snippet demonstrates how to update built-in metadata properties in a PDF document.
 */
public class PdfUpdateBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPdf)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().setAuthor("test author");
            root.getDocumentProperties().setCreatedDate(new Date());
            root.getDocumentProperties().setTitle("test title");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            // ...

            metadata.save(Constants.OutputPdf);
        }
    }
}
