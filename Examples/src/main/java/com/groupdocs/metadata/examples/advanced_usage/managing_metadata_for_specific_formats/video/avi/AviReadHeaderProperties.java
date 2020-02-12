// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.video.avi;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.AviRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet shows how to read AVI header properties.
 */
public class AviReadHeaderProperties {

    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputAvi)) {
            AviRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getHeader().getAviHeaderFlags());
            System.out.println(root.getHeader().getHeight());
            System.out.println(root.getHeader().getWidth());
            System.out.println(root.getHeader().getTotalFrames());
            System.out.println(root.getHeader().getInitialFrames());
            System.out.println(root.getHeader().getMaxBytesPerSec());
            System.out.println(root.getHeader().getPaddingGranularity());
            System.out.println(root.getHeader().getStreams());

            // ...
        }
    }
}
