// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;

import java.nio.file.Path;

/**
 * This code snippet demonstrates how to extract built-in metadata properties from a spreadsheet.
 */
public class SpreadsheetReadBuiltInProperties {
    public static SpreadsheetRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tAuthor: %s%n", root.getDocumentProperties().getAuthor());
            System.out.printf("\tCreatedTime: %s%n", root.getDocumentProperties().getCreatedTime());
            System.out.printf("\tCompany: %s%n", root.getDocumentProperties().getCompany());
            System.out.printf("\tCategory: %s%n", root.getDocumentProperties().getCategory());
            System.out.printf("\tKeywords: %s%n", root.getDocumentProperties().getKeywords());
            System.out.printf("\tLanguage: %s%n", root.getDocumentProperties().getLanguage());
            System.out.printf("\tContentType: %s%n", root.getDocumentProperties().getContentType());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
