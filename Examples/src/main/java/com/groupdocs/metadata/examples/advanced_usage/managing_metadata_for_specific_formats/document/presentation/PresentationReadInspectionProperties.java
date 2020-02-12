// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationComment;
import com.groupdocs.metadata.core.PresentationRootPackage;
import com.groupdocs.metadata.core.PresentationSlide;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to inspect a presentation.
 */
public class PresentationReadInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPpt)) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();

            if (root.getInspectionPackage().getComments() != null) {
                for (PresentationComment comment : root.getInspectionPackage().getComments()) {
                    System.out.println(comment.getAuthor());
                    System.out.println(comment.getText());
                    System.out.println(comment.getCreatedTime());
                    System.out.println(comment.getSlideNumber());
                }
            }

            if (root.getInspectionPackage().getHiddenSlides() != null) {
                for (PresentationSlide slide : root.getInspectionPackage().getHiddenSlides()) {
                    System.out.println(slide.getName());
                    System.out.println(slide.getNumber());
                    System.out.println(slide.getSlideId());
                }
            }
        }
    }
}
