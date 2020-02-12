// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.psd;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PsdLayer;
import com.groupdocs.metadata.core.PsdRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to read the header of a PSD file and extract some information about the PSD layers.
 */
public class PsdReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.PsdWithIptc)) {
            PsdRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getPsdPackage().getChannelCount());
            System.out.println(root.getPsdPackage().getColorMode());
            System.out.println(root.getPsdPackage().getCompression());
            System.out.println(root.getPsdPackage().getPhotoshopVersion());

            for (PsdLayer layer : root.getPsdPackage().getLayers()) {
                System.out.println(layer.getName());
                System.out.println(layer.getBitsPerPixel());
                System.out.println(layer.getChannelCount());
                System.out.println(layer.getFlags());
                System.out.println(layer.getHeight());
                System.out.println(layer.getWidth());

                // ...
            }

            // ...
        }
    }
}
