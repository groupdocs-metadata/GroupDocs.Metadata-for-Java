// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to inspect a WordProcessing document.
 */
public class WordProcessingReadInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            if (root.getInspectionPackage().getComments() != null) {
                for (WordProcessingComment comment : root.getInspectionPackage().getComments()) {
                    System.out.println(comment.getAuthor());
                    System.out.println(comment.getCreatedDate());
                    System.out.println(comment.getText());

                    // ...

                }
            }

            if (root.getInspectionPackage().getDigitalSignatures() != null) {
                for (DigitalSignature signature : root.getInspectionPackage().getDigitalSignatures()) {
                    System.out.println(signature.getCertificateSubject());
                    System.out.println(signature.getComments());
                    System.out.println(signature.getSignTime());

                    // ...
                }
            }

            if (root.getInspectionPackage().getFields() != null) {
                for (WordProcessingField field : root.getInspectionPackage().getFields()) {
                    System.out.println(field.getCode());
                    System.out.println(field.getResult());
                }
            }

            if (root.getInspectionPackage().getHiddenText() != null) {
                for (String textFragment : root.getInspectionPackage().getHiddenText()) {
                    System.out.println(textFragment);
                }
            }

            if (root.getInspectionPackage().getRevisions() != null) {
                for (WordProcessingRevision revision : root.getInspectionPackage().getRevisions()) {
                    System.out.println(revision.getAuthor());
                    System.out.println(revision.getDateTime());
                    System.out.println(revision.getRevisionType());
                }
            }
        }
    }
}
