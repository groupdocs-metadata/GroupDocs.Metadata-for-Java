// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

/**
 * This class provides a method to read the ID3V1 tag from an MP3 file.
 */
public class MP3ReadID3V1Tag {
    /**
     * Executes the process of reading the ID3V1 tag from the specified MP3 file.
     *
     * @param inputFile The path to the input MP3 file containing the ID3V1 tag.
     * @return A {@link MP3RootPackage} object representing the root package of the MP3 file, or null if an error occurs.
     */
    public static MP3RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();
            if (root.getID3V1() != null) {
                System.out.printf("\tAlbum: %s%n", root.getID3V1().getAlbum());
                System.out.printf("\tArtist: %s%n", root.getID3V1().getArtist());
                System.out.printf("\tTitle: %s%n", root.getID3V1().getTitle());
                System.out.printf("\tVersion: %s%n", root.getID3V1().getVersion());
                System.out.printf("\tComment: %s%n", root.getID3V1().getComment());
                // ... additional fields can be added here as needed
            } else {
                System.out.println("\tID3V1 tag not found.");
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
