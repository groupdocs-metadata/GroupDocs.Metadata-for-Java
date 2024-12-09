// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.LyricsField;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

/**
 * Demonstrates how to read the Lyrics tag from an MP3 file using the GroupDocs.Metadata API.
 * <p>
 * This class provides a static method to extract and display Lyrics3V2 tag information,
 * including lyrics, album, artist, and track details, from the specified MP3 file.
 * </p>
 */
public class MP3ReadLyricsTag {

    /**
     * Reads the Lyrics3V2 tag from the provided MP3 file and prints its contents.
     *
     * @param inputFile The path to the MP3 file from which to read the Lyrics3V2 tag.
     * @return An {@link MP3RootPackage} object representing the root package of the MP3 file, or null if an error occurs.
     */
    public static MP3RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();
            if (root.getLyrics3V2() != null) {
                System.out.printf("\tLyrics: %s%n", root.getLyrics3V2().getLyrics());
                System.out.printf("\tAlbum: %s%n", root.getLyrics3V2().getAlbum());
                System.out.printf("\tArtist: %s%n", root.getLyrics3V2().getArtist());
                System.out.printf("\tTrack: %s%n", root.getLyrics3V2().getTrack());

                for (LyricsField field : root.getLyrics3V2().toList()) {
                    System.out.printf("\t\tField: %s = %s%n", field.getID(), field.getData());
                }
            } else {
                System.out.println("\tLyrics 3V2 data not found.");
            }

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
