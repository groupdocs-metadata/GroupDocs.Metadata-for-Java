// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.Path;

/**
 * This example demonstrates how to read custom metadata properties of a ProjectManagement document.
 */
public class ProjectManagementReadCustomProperties {
    public static ProjectManagementRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();
            IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties()
                    .findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());
            for (MetadataProperty property : customProperties) {
                System.out.printf("\t%s = %s%n", property.getName(), property.getValue());
            }

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
