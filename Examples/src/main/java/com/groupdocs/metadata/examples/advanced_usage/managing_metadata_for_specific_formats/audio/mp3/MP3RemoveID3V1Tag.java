// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to remove the ID3v1 tag from an MP3 file.
 */
public class MP3RemoveID3V1Tag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithID3V1)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            root.setID3V1(null);

            metadata.save(Constants.OutputMp3);
        }
    }
}
