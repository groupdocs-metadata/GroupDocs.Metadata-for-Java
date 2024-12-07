// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ID3V2AttachedPictureFrame;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

/**
 * This example shows how to read the ID3v2 tag in an MP3 file.
 */
public class MP3ReadID3V2Tag {
    public static MP3RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();
            if (root.getID3V2() != null) {
                System.out.printf("\tAlbum: %s%n", root.getID3V2().getAlbum());
                System.out.printf("\tArtist: %s%n", root.getID3V2().getArtist());
                System.out.printf("\tBand: %s%n", root.getID3V2().getBand());
                System.out.printf("\tTitle: %s%n", root.getID3V2().getTitle());
                System.out.printf("\tComposers: %s%n", root.getID3V2().getComposers());
                System.out.printf("\tCopyright: %s%n", root.getID3V2().getCopyright());
                System.out.printf("\tPublisher: %s%n", root.getID3V2().getPublisher());
                System.out.printf("\tOriginal Album: %s%n", root.getID3V2().getOriginalAlbum());
                System.out.printf("\tMusical Key: %s%n", root.getID3V2().getMusicalKey());
                if (root.getID3V2().getAttachedPictures() != null) {
                    for (ID3V2AttachedPictureFrame attachedPicture : root.getID3V2().getAttachedPictures()) {
                        System.out.printf("\t\tAttached Picture Type: %s%n", attachedPicture.getAttachedPictureType());
                        System.out.printf("\t\tMimeType: %s%n", attachedPicture.getMimeType());
                        System.out.printf("\t\tDescription: %s%n", attachedPicture.getDescription());
                    }
                }
            }

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
