// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to extract built-in metadata properties from a PDF document.
 */
public class PdfReadBuiltInProperties {
    public static PdfRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PdfRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tAuthor: %s%n", root.getDocumentProperties().getAuthor());
            System.out.printf("\tCreation Date: %s%n", root.getDocumentProperties().getCreatedDate());
            System.out.printf("\tSubject: %s%n", root.getDocumentProperties().getSubject());
            System.out.printf("\tProducer: %s%n", root.getDocumentProperties().getProducer());
            System.out.printf("\tKeywords: %s%n", root.getDocumentProperties().getKeywords());

            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
