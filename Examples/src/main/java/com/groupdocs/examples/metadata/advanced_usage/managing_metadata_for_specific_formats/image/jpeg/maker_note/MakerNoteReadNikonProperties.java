// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.NikonMakerNotePackage;

import java.nio.file.Path;

/**
 * This code sample shows how to extract Nikon MakerNote properties.
 */
public class MakerNoteReadNikonProperties {
    public static JpegRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            NikonMakerNotePackage makerNote = (NikonMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.printf("\tColor Mode: %s%n", makerNote.getColorMode());
                System.out.printf("\tFlash Setting: %s%n", makerNote.getFlashSetting());
                System.out.printf("\tFlash Type: %s%n", makerNote.getFlashType());
                System.out.printf("\tFocus Mode: %s%n", makerNote.getFocusMode());
                System.out.printf("\tQuality: %s%n", makerNote.getQuality());
                System.out.printf("\tSharpness: %s%n", makerNote.getSharpness());
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
