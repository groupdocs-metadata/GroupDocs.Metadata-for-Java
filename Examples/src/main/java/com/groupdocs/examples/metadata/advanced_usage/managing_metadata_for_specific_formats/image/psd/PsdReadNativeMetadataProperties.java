// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.psd;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PsdLayer;
import com.groupdocs.metadata.core.PsdRootPackage;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to read the header of a PSD file and extract some information about the PSD layers.
 */
public class PsdReadNativeMetadataProperties {
    public static PsdRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PsdRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tChannel Count: %d%n", root.getPsdPackage().getChannelCount());
            System.out.printf("\tColor Mode: %s%n", root.getPsdPackage().getColorMode());
            System.out.printf("\tCompression: %s%n", root.getPsdPackage().getCompression());
            System.out.printf("\tPhotoshop Version: %s%n", root.getPsdPackage().getPhotoshopVersion());
            for (PsdLayer layer : root.getPsdPackage().getLayers()) {
                System.out.printf("\t\tName: %s%n", layer.getName());
                System.out.printf("\t\tBits Per Pixel: %d%n", layer.getBitsPerPixel());
                System.out.printf("\t\tChannel Count: %d%n", layer.getChannelCount());
                System.out.printf("\t\tFlags: %s%n", layer.getFlags());
                System.out.printf("\t\tHeight: %d%n", layer.getHeight());
                System.out.printf("\t\tWidth: %d%n", layer.getWidth());
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
