// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ImageResourceBlock;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The code sample below demonstrates how to extract image resource blocks (building blocks of the Photoshop file format) from a JPEG image.
 */
public class JpegReadImageResourceBlocks {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithIrb)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();

            if (root.getImageResourcePackage() != null) {
                for (ImageResourceBlock block : root.getImageResourcePackage().toList()) {
                    System.out.println(block.getSignature());
                    System.out.println(block.getID());
                    System.out.println(block.getName());
                    System.out.println(block.getData());
                }
            }
        }
    }
}
