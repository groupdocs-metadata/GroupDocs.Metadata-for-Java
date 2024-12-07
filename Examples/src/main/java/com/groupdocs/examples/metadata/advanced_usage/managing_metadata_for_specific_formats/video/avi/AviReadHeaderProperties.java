// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.avi;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.AviRootPackage;

import java.nio.file.Path;

/**
 * This code snippet shows how to read AVI header properties.
 */
public class AviReadHeaderProperties {

    public static AviRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            AviRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tAviHeaderFlags: %s%n", root.getHeader().getAviHeaderFlags());
            System.out.printf("\tHeight: %s%n", root.getHeader().getHeight());
            System.out.printf("\tWidth: %s%n", root.getHeader().getWidth());
            System.out.printf("\tTotalFrames: %s%n", root.getHeader().getTotalFrames());
            System.out.printf("\tInitialFrames: %s%n", root.getHeader().getInitialFrames());
            System.out.printf("\tMaxBytesPerSec: %s%n", root.getHeader().getMaxBytesPerSec());
            System.out.printf("\tPaddingGranularity: %s%n", root.getHeader().getPaddingGranularity());
            System.out.printf("\tStreams: %s%n", root.getHeader().getStreams());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
