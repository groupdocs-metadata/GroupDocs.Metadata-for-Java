// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.note;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.NotePage;
import com.groupdocs.metadata.core.NoteRootPackage;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to inspect a note document.
 */
public class NoteReadInspectionProperties {
    public static NoteRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            NoteRootPackage root = metadata.getRootPackageGeneric();
            if (root.getInspectionPackage().getPages() != null) {
                for (NotePage page : root.getInspectionPackage().getPages()) {
                    System.out.printf("\tTitle: %s%n", page.getTitle());
                    System.out.printf("\tAuthor: %s%n", page.getAuthor());
                    System.out.printf("\tCreation Time: %s%n", page.getCreationTime());
                    System.out.printf("\tLast Modification Time: %s%n", page.getLastModificationTime());
                }
            } else {
                System.out.println("\tInspection Package Pages not found.");
            }

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
