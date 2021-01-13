// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

/**
 * This example demonstrates how to read custom metadata properties of a ProjectManagement document.
 */
public class ProjectManagementReadCustomProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputMpp)) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

            IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());

            for (MetadataProperty property : customProperties) {
                System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
            }
        }
    }
}
