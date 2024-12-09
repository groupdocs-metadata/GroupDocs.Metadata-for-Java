// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationRootPackage;

import java.nio.file.Path;

/**
 * This example shows how to extract built-in metadata properties from a presentation.
 */
public class PresentationReadBuiltInProperties {
    public static PresentationRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tAuthor: %s%n", root.getDocumentProperties().getAuthor());
            System.out.printf("\tCreated Time: %s%n", root.getDocumentProperties().getCreatedTime());
            System.out.printf("\tCompany: %s%n", root.getDocumentProperties().getCompany());
            System.out.printf("\tCategory: %s%n", root.getDocumentProperties().getCategory());
            System.out.printf("\tKeywords: %s%n", root.getDocumentProperties().getKeywords());
            System.out.printf("\tLast Printed Date: %s%n", root.getDocumentProperties().getLastPrintedDate());
            System.out.printf("\tName Of Application: %s%n", root.getDocumentProperties().getNameOfApplication());

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
