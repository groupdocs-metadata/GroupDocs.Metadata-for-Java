// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ID3V1Tag;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to update the ID3v1 tag in an MP3 file.
 */
public class MP3UpdateID3V1Tag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithID3V1)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            if (root.getID3V1() == null) {
                root.setID3V1(new ID3V1Tag());
            }

            root.getID3V1().setAlbum("test album");
            root.getID3V1().setArtist("test artist");
            root.getID3V1().setTitle("test title");
            root.getID3V1().setComment("test comment");
            root.getID3V1().setYear("2019");

            // ...

            metadata.save(Constants.OutputMp3);
        }
    }
}
