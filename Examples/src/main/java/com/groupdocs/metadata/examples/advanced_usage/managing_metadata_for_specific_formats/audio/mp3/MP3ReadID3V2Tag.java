// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ID3V2AttachedPictureFrame;
import com.groupdocs.metadata.core.MP3RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to read the ID3v2 tag in an MP3 file.
 */
public class MP3ReadID3V2Tag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MP3WithID3V2)) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            if (root.getID3V2() != null) {
                System.out.println(root.getID3V2().getAlbum());
                System.out.println(root.getID3V2().getArtist());
                System.out.println(root.getID3V2().getBand());
                System.out.println(root.getID3V2().getTitle());
                System.out.println(root.getID3V2().getComposers());
                System.out.println(root.getID3V2().getCopyright());
                System.out.println(root.getID3V2().getPublisher());
                System.out.println(root.getID3V2().getOriginalAlbum());
                System.out.println(root.getID3V2().getMusicalKey());

                if (root.getID3V2().getAttachedPictures() != null) {
                    for (ID3V2AttachedPictureFrame attachedPicture : root.getID3V2().getAttachedPictures()) {
                        System.out.println(attachedPicture.getAttachedPictureType());
                        System.out.println(attachedPicture.getMimeType());
                        System.out.println(attachedPicture.getDescription());

                        // ...
                    }
                }

                // ...
            }
        }
    }
}
