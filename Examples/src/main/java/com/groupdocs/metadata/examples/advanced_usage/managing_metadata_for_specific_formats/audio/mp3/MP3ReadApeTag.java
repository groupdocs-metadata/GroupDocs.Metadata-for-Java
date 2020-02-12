// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;


import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to read the getApeV2() tag in an MP3 file.
 */
public class MP3ReadApeTag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithApe)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            if (root.getApeV2() != null) {
                System.out.println(root.getApeV2().getAlbum());
                System.out.println(root.getApeV2().getTitle());
                System.out.println(root.getApeV2().getArtist());
                System.out.println(root.getApeV2().getComposer());
                System.out.println(root.getApeV2().getCopyright());
                System.out.println(root.getApeV2().getGenre());
                System.out.println(root.getApeV2().getLanguage());

                // ...
            }
        }
    }
}
