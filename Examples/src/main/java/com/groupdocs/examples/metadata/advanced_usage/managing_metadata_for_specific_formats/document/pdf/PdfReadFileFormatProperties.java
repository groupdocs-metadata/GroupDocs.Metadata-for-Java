// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;

import java.nio.file.Path;

/**
 * This code snippet shows how to detect the PDF version a loaded document and extract some additional file format information.
 */
public class PdfReadFileFormatProperties {
    public static PdfRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PdfRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Format: %s%n", root.getPdfType().getFileFormat());
            System.out.printf("\tVersion: %s%n", root.getPdfType().getVersion());
            System.out.printf("\tMIME Type: %s%n", root.getPdfType().getMimeType());
            System.out.printf("\tExtension: %s%n", root.getPdfType().getExtension());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
