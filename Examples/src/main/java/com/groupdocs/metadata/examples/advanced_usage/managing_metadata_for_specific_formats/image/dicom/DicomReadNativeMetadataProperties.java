// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.dicom;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DicomRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to read DICOM format-specific metadata properties.
 */
public class DicomReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDicom)) {
            DicomRootPackage root = metadata.getRootPackageGeneric();
            if (root.getDicomPackage() != null) {
                System.out.println(root.getDicomPackage().getBitsAllocated());
                System.out.println(root.getDicomPackage().getReds());
                System.out.println(root.getDicomPackage().getGreens());
                System.out.println(root.getDicomPackage().getBlues());
                System.out.println(root.getDicomPackage().getNumberOfFrames());

                // ...
            }
        }
    }
}
