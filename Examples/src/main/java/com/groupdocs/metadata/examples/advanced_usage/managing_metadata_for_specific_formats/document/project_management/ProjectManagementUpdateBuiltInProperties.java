// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This code sample demonstrates how to update built-in properties in a ProjectManagement document.
 */
public class ProjectManagementUpdateBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputMpp)) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().setAuthor("test author");
            root.getDocumentProperties().setCreationDate(new Date());
            root.getDocumentProperties().setCompany("GroupDocs");
            root.getDocumentProperties().setComments("test comment");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            // ...

            metadata.save(Constants.OutputMpp);
        }
    }
}
