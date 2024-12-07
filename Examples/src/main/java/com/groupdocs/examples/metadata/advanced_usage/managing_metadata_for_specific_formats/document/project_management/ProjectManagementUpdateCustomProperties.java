// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to update custom metadata properties in a ProjectManagement document.
 */
public class ProjectManagementUpdateCustomProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("updated_mpp.mpp");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();
            root.getDocumentProperties().set("customProperty1", "some value");
            root.getDocumentProperties().set("customProperty2", 7);
            root.getDocumentProperties().set("customProperty3", true);

            metadata.save(outputPath.toString());
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
