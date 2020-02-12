// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet shows how to detect the PDF version a loaded document and extract some additional file format information.
 */
public class PdfReadFileFormatProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPdf)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getPdfType().getFileFormat());
            System.out.println(root.getPdfType().getVersion());
            System.out.println(root.getPdfType().getMimeType());
            System.out.println(root.getPdfType().getExtension());
        }
    }
}
