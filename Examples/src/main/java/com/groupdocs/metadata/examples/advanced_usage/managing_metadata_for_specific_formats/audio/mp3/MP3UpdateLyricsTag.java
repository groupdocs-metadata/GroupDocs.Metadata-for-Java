// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.LyricsField;
import com.groupdocs.metadata.core.LyricsTag;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to update the Lyrics tag in an MP3 file
 */
public class MP3UpdateLyricsTag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithLyrics)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            if (root.getLyrics3V2() == null) {
                root.setLyrics3V2(new LyricsTag());
            }

            root.getLyrics3V2().setLyrics("[00:01]Test lyrics");
            root.getLyrics3V2().setArtist("test artist");
            root.getLyrics3V2().setAlbum("test album");
            root.getLyrics3V2().setTrack("test track");

            // You can add a fully custom field to the tag
            root.getLyrics3V2().set(new LyricsField("ABC", "custom value"));

            // ...

            metadata.save(Constants.OutputMp3);
        }
    }
}
