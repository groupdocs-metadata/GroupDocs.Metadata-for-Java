// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample demonstrates how to update built-in properties in a ProjectManagement document.
 */
public class ProjectManagementUpdateBuiltInProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("updated_mpp.mpp");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();
            root.getDocumentProperties().setAuthor("test author");
            root.getDocumentProperties().setCreationDate(new Date());
            root.getDocumentProperties().setCompany("GroupDocs");
            root.getDocumentProperties().setComments("test comment");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            metadata.save(outputPath.toString());
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
