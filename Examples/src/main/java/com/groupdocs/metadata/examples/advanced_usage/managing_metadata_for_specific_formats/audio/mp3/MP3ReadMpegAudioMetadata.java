// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to read MPEG audio metadata from an MP3 file.
 */
public class MP3ReadMpegAudioMetadata {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithID3V2)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getMpegAudioPackage().getBitrate());
            System.out.println(root.getMpegAudioPackage().getChannelMode());
            System.out.println(root.getMpegAudioPackage().getEmphasis());
            System.out.println(root.getMpegAudioPackage().getFrequency());
            System.out.println(root.getMpegAudioPackage().getHeaderPosition());
            System.out.println(root.getMpegAudioPackage().getLayer());

            // ...
        }
    }
}
