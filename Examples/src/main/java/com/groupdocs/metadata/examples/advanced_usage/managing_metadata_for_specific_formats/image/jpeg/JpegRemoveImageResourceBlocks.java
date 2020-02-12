// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet demonstrates how to remove Photoshop metadata from a JPEG image.
 */
public class JpegRemoveImageResourceBlocks {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithIrb)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            root.removeImageResourcePackage();

            metadata.save(Constants.OutputJpeg);
        }
    }
}
