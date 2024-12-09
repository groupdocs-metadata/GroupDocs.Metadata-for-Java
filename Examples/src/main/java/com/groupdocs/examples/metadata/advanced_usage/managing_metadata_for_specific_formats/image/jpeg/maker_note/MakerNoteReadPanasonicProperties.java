// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.PanasonicMakerNotePackage;

import java.nio.file.Path;

/**
 * This code sample shows how to extract Panasonic MakerNote properties.
 */
public class MakerNoteReadPanasonicProperties {
    public static JpegRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            PanasonicMakerNotePackage makerNote = (PanasonicMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.printf("\tAccessory Serial Number: %s%n", makerNote.getAccessorySerialNumber());
                System.out.printf("\tAccessory Type: %s%n", makerNote.getAccessoryType());
                System.out.printf("\tMacro Mode: %s%n", makerNote.getMacroMode());
                System.out.printf("\tLens Serial Number: %s%n", makerNote.getLensSerialNumber());
                System.out.printf("\tLens Type: %s%n", makerNote.getLensType());
            } else {
                System.out.println("\tMaker Note Package not found.");
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
