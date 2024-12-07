// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;

/**
 * This code sample shows how to inspect a WordProcessing document.
 */
public class WordProcessingReadInspectionProperties {
    public static WordProcessingRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();
            if (root.getInspectionPackage().getComments() != null) {
                for (WordProcessingComment comment : root.getInspectionPackage().getComments()) {
                    System.out.printf("\tAuthor: %s%n", comment.getAuthor());
                    System.out.printf("\tCreated Date: %s%n", comment.getCreatedDate());
                    final String commentText = comment.getText();
                    System.out.printf("\tText: %s%n", commentText.substring(0, Math.min(commentText.length(), 50)) + "...");
                }
            }
            if (root.getInspectionPackage().getDigitalSignatures() != null) {
                for (DigitalSignature signature : root.getInspectionPackage().getDigitalSignatures()) {
                    System.out.printf("\tCertificate Subject: %s%n", signature.getCertificateSubject());
                    System.out.printf("\tComments: %s%n", signature.getComments());
                    System.out.printf("\tSign Time: %s%n", signature.getSignTime());
                }
            }
            if (root.getInspectionPackage().getFields() != null) {
                for (WordProcessingField field : root.getInspectionPackage().getFields()) {
                    System.out.printf("\tCode: %s%n", field.getCode());
                    System.out.printf("\tResult: %s%n", field.getResult());
                }
            }
            if (root.getInspectionPackage().getHiddenText() != null) {
                for (String textFragment : root.getInspectionPackage().getHiddenText()) {
                    System.out.println(textFragment);
                }
            }
            if (root.getInspectionPackage().getRevisions() != null) {
                for (WordProcessingRevision revision : root.getInspectionPackage().getRevisions()) {
                    System.out.printf("\tAuthor: %s%n", revision.getAuthor());
                    System.out.printf("\tDate Time: %s%n", revision.getDateTime());
                    System.out.printf("\tRevision Type: %s%n", revision.getRevisionType());
                }
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
