// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to read the getID3V1() tag in an MP3 file.
 */
public class MP3ReadID3V1Tag {
    public static MP3RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();
            if (root.getID3V1() != null) {
                System.out.printf("\tAlbum: %s%n", root.getID3V1().getAlbum());
                System.out.printf("\tArtist: %s%n", root.getID3V1().getArtist());
                System.out.printf("\tTitle: %s%n", root.getID3V1().getTitle());
                System.out.printf("\tVersion: %s%n", root.getID3V1().getVersion());
                System.out.printf("\tComment: %s%n", root.getID3V1().getComment());
                // ...
            } else {
                System.out.println("\tID3V1 tag not found.");
            }

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
