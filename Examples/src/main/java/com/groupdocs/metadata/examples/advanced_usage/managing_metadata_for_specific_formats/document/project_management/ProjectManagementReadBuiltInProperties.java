// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to extract built-in properties of a ProjectManagement document.
 */
public class ProjectManagementReadBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputMpp)) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getAuthor());
            System.out.println(root.getDocumentProperties().getCreationDate());
            System.out.println(root.getDocumentProperties().getCompany());
            System.out.println(root.getDocumentProperties().getCategory());
            System.out.println(root.getDocumentProperties().getKeywords());
            System.out.println(root.getDocumentProperties().getRevision());
            System.out.println(root.getDocumentProperties().getSubject());

            // ...
        }
    }
}
