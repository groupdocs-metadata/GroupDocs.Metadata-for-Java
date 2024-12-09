// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.psd;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PsdRootPackage;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to extract basic EXIF metadata properties from a PSD image.
 */
public class PsdReadBasicExifProperties {
    public static PsdRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PsdRootPackage root = metadata.getRootPackageGeneric();
            if (root.getExifPackage() != null) {
                System.out.printf("\tArtist: %s%n", root.getExifPackage().getArtist());
                System.out.printf("\tCopyright: %s%n", root.getExifPackage().getCopyright());
                System.out.printf("\tImage Description: %s%n", root.getExifPackage().getImageDescription());
                System.out.printf("\tMake: %s%n", root.getExifPackage().getMake());
                System.out.printf("\tModel: %s%n", root.getExifPackage().getModel());
                System.out.printf("\tSoftware: %s%n", root.getExifPackage().getSoftware());
                System.out.printf("\tImage Width: %d%n", root.getExifPackage().getImageWidth());
                System.out.printf("\tImage Length: %d%n", root.getExifPackage().getImageLength());
                System.out.printf("\tBody Serial Number: %s%n", root.getExifPackage().getExifIfdPackage().getBodySerialNumber());
                System.out.printf("\tCamera Owner Name: %s%n", root.getExifPackage().getExifIfdPackage().getCameraOwnerName());
                System.out.printf("\tUser Comment: %s%n", root.getExifPackage().getExifIfdPackage().getUserComment());
                System.out.printf("\tAltitude: %s%n", root.getExifPackage().getGpsPackage().getAltitude());
                System.out.printf("\tLatitude Ref: %s%n", root.getExifPackage().getGpsPackage().getLatitudeRef());
                System.out.printf("\tLongitude Ref: %s%n", root.getExifPackage().getGpsPackage().getLongitudeRef());
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
