// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.CanonMakerNotePackage;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.examples.Constants;


/**
 * This code sample shows how to extract Canon MakerNote properties.
 */
public class MakerNoteReadCanonProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.CanonJpeg)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();

            CanonMakerNotePackage makerNote = (CanonMakerNotePackage) root.getMakerNotePackage();
            if (makerNote != null) {
                System.out.println(makerNote.getCanonFirmwareVersion());
                System.out.println(makerNote.getCanonImageType());
                System.out.println(makerNote.getOwnerName());
                System.out.println(makerNote.getCanonModelID());

                // ...

                if (makerNote.getCameraSettings() != null) {
                    System.out.println(makerNote.getCameraSettings().getAFPoint());
                    System.out.println(makerNote.getCameraSettings().getCameraIso());
                    System.out.println(makerNote.getCameraSettings().getContrast());
                    System.out.println(makerNote.getCameraSettings().getDigitalZoom());

                    // ...
                }
            }
        }
    }
}
