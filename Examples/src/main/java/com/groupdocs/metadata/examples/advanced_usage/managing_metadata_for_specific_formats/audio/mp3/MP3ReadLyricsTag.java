// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.LyricsField;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read the Lyrics tag from an MP3 file.
 */
public class MP3ReadLyricsTag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithLyrics)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            if (root.getLyrics3V2() != null) {
                System.out.println(root.getLyrics3V2().getLyrics());
                System.out.println(root.getLyrics3V2().getAlbum());
                System.out.println(root.getLyrics3V2().getArtist());
                System.out.println(root.getLyrics3V2().getTrack());

                // ...

                // Alternatively, you can loop through a full list of tag fields
                for (LyricsField field : root.getLyrics3V2().toList()) {
                    System.out.println(String.format("%s = %s", field.getID(), field.getData()));
                }
            }
        }
    }
}
