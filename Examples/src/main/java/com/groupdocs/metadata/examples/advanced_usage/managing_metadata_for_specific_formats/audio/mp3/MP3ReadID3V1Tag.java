// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read the getID3V1() tag in an MP3 file.
 */
public class MP3ReadID3V1Tag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithID3V1)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            if (root.getID3V1() != null) {
                System.out.println(root.getID3V1().getAlbum());
                System.out.println(root.getID3V1().getArtist());
                System.out.println(root.getID3V1().getTitle());
                System.out.println(root.getID3V1().getVersion());
                System.out.println(root.getID3V1().getComment());

                // ...
            }
        }
    }
}
