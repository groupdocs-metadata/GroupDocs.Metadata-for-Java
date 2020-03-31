// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.NikonMakerNotePackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract Nikon MakerNote properties.
 */
public class MakerNoteReadNikonProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.NikonJpeg)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();

            NikonMakerNotePackage makerNote = (NikonMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.println(makerNote.getColorMode());
                System.out.println(makerNote.getFlashSetting());
                System.out.println(makerNote.getFlashType());
                System.out.println(makerNote.getFocusMode());
                System.out.println(makerNote.getQuality());
                System.out.println(makerNote.getSharpness());

                // ...
            }
        }
    }
}
