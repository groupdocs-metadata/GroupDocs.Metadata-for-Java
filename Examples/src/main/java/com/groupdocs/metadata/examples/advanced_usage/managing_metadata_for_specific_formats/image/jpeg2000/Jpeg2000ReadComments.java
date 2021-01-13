// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg2000;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.Jpeg2000RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet demonstrates how to read JPEG2000 image comments.
 */
public class Jpeg2000ReadComments {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputJpeg2000)) {
            Jpeg2000RootPackage root = metadata.getRootPackageGeneric();

            if (root.getJpeg2000Package().getComments() != null) {
                for (String comment : root.getJpeg2000Package().getComments()) {
                    System.out.println(comment);
                }
            }
        }
    }
}
