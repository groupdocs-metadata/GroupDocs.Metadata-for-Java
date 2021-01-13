// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.note;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.NotePage;
import com.groupdocs.metadata.core.NoteRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to inspect a note document.
 */
public class NoteReadInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputOne)) {
            NoteRootPackage root = metadata.getRootPackageGeneric();

            if (root.getInspectionPackage().getPages() != null) {
                for (NotePage page : root.getInspectionPackage().getPages()) {
                    System.out.println(page.getTitle());
                    System.out.println(page.getAuthor());
                    System.out.println(page.getCreationTime());
                    System.out.println(page.getLastModificationTime());
                }
            }
        }
    }
}
