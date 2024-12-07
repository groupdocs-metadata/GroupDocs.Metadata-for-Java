// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to obtain the text statistics for a PDF document.
 */
public class PdfReadDocumentStatistics {
    public static PdfRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PdfRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tCharacter Count: %d%n", root.getDocumentStatistics().getCharacterCount());
            System.out.printf("\tPage Count: %d%n", root.getDocumentStatistics().getPageCount());
            System.out.printf("\tWord Count: %d%n", root.getDocumentStatistics().getWordCount());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
