// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to remove the ID3v2 tag from an MP3 file.
 */
public class MP3RemoveLyricsTag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithLyrics)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            root.setLyrics3V2(null);

            metadata.save(Constants.OutputMp3);
        }
    }
}
