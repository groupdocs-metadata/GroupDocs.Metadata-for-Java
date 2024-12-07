// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.CanonMakerNotePackage;
import com.groupdocs.metadata.core.JpegRootPackage;

import java.nio.file.Path;


/**
 * This code sample shows how to extract Canon MakerNote properties.
 */
public class MakerNoteReadCanonProperties {
    public static JpegRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            CanonMakerNotePackage makerNote = (CanonMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.printf("\tCanon Firmware Version: %s%n", makerNote.getCanonFirmwareVersion());
                System.out.printf("\tCanon Image Type: %s%n", makerNote.getCanonImageType());
                System.out.printf("\tOwner Name: %s%n", makerNote.getOwnerName());
                System.out.printf("\tCanon Model ID: %s%n", makerNote.getCanonModelID());
                if (makerNote.getCameraSettings() != null) {
                    System.out.printf("\t\tAF Point: %s%n", makerNote.getCameraSettings().getAFPoint());
                    System.out.printf("\t\tCamera ISO: %s%n", makerNote.getCameraSettings().getCameraIso());
                    System.out.printf("\t\tContrast: %s%n", makerNote.getCameraSettings().getContrast());
                    System.out.printf("\t\tDigital Zoom: %s%n", makerNote.getCameraSettings().getDigitalZoom());
                }
            } else {
                System.out.println("\tMaker Note Package not found.");
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
