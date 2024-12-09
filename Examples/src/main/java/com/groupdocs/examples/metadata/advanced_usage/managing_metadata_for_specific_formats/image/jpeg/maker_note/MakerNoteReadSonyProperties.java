// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.SonyMakerNotePackage;

import java.nio.file.Path;

/**
 * This code sample shows how to extract Sony MakerNote properties.
 */
public class MakerNoteReadSonyProperties {
    public static JpegRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            SonyMakerNotePackage makerNote = (SonyMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.printf("\tCreative Style: %s%n", makerNote.getCreativeStyle());
                System.out.printf("\tColor Mode: %s%n", makerNote.getColorMode());
                System.out.printf("\tJpeg Quality: %s%n", makerNote.getJpegQuality());
                System.out.printf("\tBrightness: %s%n", makerNote.getBrightness());
                System.out.printf("\tSharpness: %s%n", makerNote.getSharpness());
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
