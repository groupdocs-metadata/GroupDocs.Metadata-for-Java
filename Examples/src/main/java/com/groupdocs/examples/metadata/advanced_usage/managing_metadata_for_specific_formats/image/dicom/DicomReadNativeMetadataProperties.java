// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.dicom;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DicomRootPackage;

import java.nio.file.Path;
import java.util.Arrays;

/**
 * This example demonstrates how to read DICOM format-specific metadata properties.
 */
public class DicomReadNativeMetadataProperties {
    public static DicomRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            DicomRootPackage root = metadata.getRootPackageGeneric();
            if (root.getDicomPackage() != null) {
                System.out.printf("\tBits allocated: %d%n", root.getDicomPackage().getBitsAllocated());
                System.out.printf("\tReds: %s%n", Arrays.toString(root.getDicomPackage().getReds()));
                System.out.printf("\tGreens: %s%n", Arrays.toString(root.getDicomPackage().getGreens()));
                System.out.printf("\tBlues: %s%n", Arrays.toString(root.getDicomPackage().getBlues()));
                System.out.printf("\tNumber of frames: %d%n", root.getDicomPackage().getNumberOfFrames());
            } else {
                System.out.println("\tDicom package data not found.");
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
