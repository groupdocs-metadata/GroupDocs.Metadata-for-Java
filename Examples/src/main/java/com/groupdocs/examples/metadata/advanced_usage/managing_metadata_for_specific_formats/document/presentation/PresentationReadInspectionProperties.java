// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationComment;
import com.groupdocs.metadata.core.PresentationRootPackage;
import com.groupdocs.metadata.core.PresentationSlide;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to inspect a presentation.
 */
public class PresentationReadInspectionProperties {
    public static PresentationRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();
            if (root.getInspectionPackage().getComments() != null) {
                for (PresentationComment comment : root.getInspectionPackage().getComments()) {
                    System.out.printf("\tAuthor: %s%n", comment.getAuthor());
                    final String commentText = comment.getText();
                    System.out.printf("\tText: %s%n", commentText.substring(0, Math.min(commentText.length(), 50)) + "...");
                    System.out.printf("\tCreated Time: %s%n", comment.getCreatedTime());
                    System.out.printf("\tSlide Number: %d%n", comment.getSlideNumber());
                }
            }
            if (root.getInspectionPackage().getHiddenSlides() != null) {
                for (PresentationSlide slide : root.getInspectionPackage().getHiddenSlides()) {
                    System.out.printf("\tName: %s%n", slide.getName());
                    System.out.printf("\tNumber: %d%n", slide.getNumber());
                    System.out.printf("\tSlide ID: %s%n", slide.getSlideId());
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
