// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ID3V2Tag;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The code sample shows how to update the ID3v2 tag in an MP3 file.
 */
public class MP3UpdateID3V2Tag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithID3V2)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            if (root.getID3V2() == null) {
                root.setID3V2(new ID3V2Tag());
            }

            root.getID3V2().setAlbum("test album");
            root.getID3V2().setArtist("test artist");
            root.getID3V2().setBand("test band");
            root.getID3V2().setTrackNumber("1");
            root.getID3V2().setMusicalKey("C#");
            root.getID3V2().setTitle("code sample");
            root.getID3V2().setDate("2019");

            // ...

            metadata.save(Constants.OutputMp3);
        }
    }
}
