// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to extract built-in properties of a ProjectManagement document.
 */
public class ProjectManagementReadBuiltInProperties {
    public static ProjectManagementRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            ProjectManagementRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tAuthor: %s%n", root.getDocumentProperties().getAuthor());
            System.out.printf("\tCreation Date: %s%n", root.getDocumentProperties().getCreationDate());
            System.out.printf("\tCompany: %s%n", root.getDocumentProperties().getCompany());
            System.out.printf("\tCategory: %s%n", root.getDocumentProperties().getCategory());
            System.out.printf("\tKeywords: %s%n", root.getDocumentProperties().getKeywords());
            System.out.printf("\tRevision: %s%n", root.getDocumentProperties().getRevision());
            System.out.printf("\tSubject: %s%n", root.getDocumentProperties().getSubject());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
