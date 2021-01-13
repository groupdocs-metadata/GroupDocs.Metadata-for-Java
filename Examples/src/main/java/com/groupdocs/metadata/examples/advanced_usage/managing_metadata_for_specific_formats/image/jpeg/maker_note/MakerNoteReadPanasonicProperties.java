// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.PanasonicMakerNotePackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract Panasonic MakerNote properties.
 */
public class MakerNoteReadPanasonicProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.PanasonicJpeg)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();

            PanasonicMakerNotePackage makerNote = (PanasonicMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.println(makerNote.getAccessorySerialNumber());
                System.out.println(makerNote.getAccessoryType());
                System.out.println(makerNote.getMacroMode());
                System.out.println(makerNote.getLensSerialNumber());
                System.out.println(makerNote.getLensType());

                // ...
            }
        }
    }
}
