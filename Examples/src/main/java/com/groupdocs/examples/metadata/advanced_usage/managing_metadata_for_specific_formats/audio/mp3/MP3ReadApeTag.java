// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;


import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

/**
 * This class provides a method to read the APEv2 tag information from an MP3 file.
 */
public class MP3ReadApeTag {
    /**
     * Reads and prints the APEv2 tag details from the specified MP3 file.
     *
     * @param inputFile The path to the input MP3 file containing the APEv2 tag.
     * @return An instance of {@link MP3RootPackage} if the APEv2 tag is found, otherwise null.
     */
    public static MP3RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();
            if (root.getApeV2() != null) {
                System.out.printf("\tAlbum: %s%n", root.getApeV2().getAlbum());
                System.out.printf("\tTitle: %s%n", root.getApeV2().getTitle());
                System.out.printf("\tArtist: %s%n", root.getApeV2().getArtist());
                System.out.printf("\tComposer: %s%n", root.getApeV2().getComposer());
                System.out.printf("\tCopyright: %s%n", root.getApeV2().getCopyright());
                System.out.printf("\tGenre: %s%n", root.getApeV2().getGenre());
                System.out.printf("\tLanguage: %s%n", root.getApeV2().getLanguage());
                // Additional fields can be printed here as needed
            } else {
                System.out.println("\tAPEv2 tag not found.");
            }

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
