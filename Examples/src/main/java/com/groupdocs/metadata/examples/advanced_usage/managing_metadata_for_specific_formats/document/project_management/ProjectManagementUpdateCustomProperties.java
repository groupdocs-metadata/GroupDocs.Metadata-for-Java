// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to update custom metadata properties in a ProjectManagement document.
 */
public class ProjectManagementUpdateCustomProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputMpp)) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().set("customProperty1", "some value");
            root.getDocumentProperties().set("customProperty2", 7);
            root.getDocumentProperties().set("customProperty3", true);

            metadata.save(Constants.OutputMpp);
        }
    }
}
