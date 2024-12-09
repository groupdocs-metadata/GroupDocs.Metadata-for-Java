// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.note;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.NoteRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to obtain simple text statistics for a Note document.
 */
public class NoteReadDocumentStatistics {
    public static NoteRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            NoteRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tCharacter Count: %d%n", root.getDocumentStatistics().getCharacterCount());
            System.out.printf("\tPage Count: %d%n", root.getDocumentStatistics().getPageCount());
            System.out.printf("\tWord Count: %d%n", root.getDocumentStatistics().getWordCount());

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
