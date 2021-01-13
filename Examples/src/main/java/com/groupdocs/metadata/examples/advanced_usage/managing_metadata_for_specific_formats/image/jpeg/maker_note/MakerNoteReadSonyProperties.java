// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.SonyMakerNotePackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract Sony MakerNote properties.
 */
public class MakerNoteReadSonyProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.SonyJpeg)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();

            SonyMakerNotePackage makerNote = (SonyMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.println(makerNote.getCreativeStyle());
                System.out.println(makerNote.getColorMode());
                System.out.println(makerNote.getJpegQuality());
                System.out.println(makerNote.getBrightness());
                System.out.println(makerNote.getSharpness());

                // ...
            }
        }
    }
}
