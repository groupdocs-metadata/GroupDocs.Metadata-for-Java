// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ID3V1Tag;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class provides functionality to update the ID3v1 tag in an MP3 file.
 */
public class MP3UpdateID3V1Tag {
    /**
     * Updates the ID3v1 tag in the specified MP3 file and saves the modified MP3 file.
     *
     * @param inputFile The path to the input MP3 file in which to update the ID3v1 tag.
     * @return The path to the modified MP3 file saved in the output directory.
     */
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("MP3UpdateID3V1Tag.mp3");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();
            if (root.getID3V1() == null) {
                root.setID3V1(new ID3V1Tag());
            }
            root.getID3V1().setAlbum("test album");
            root.getID3V1().setArtist("test artist");
            root.getID3V1().setTitle("test title");
            root.getID3V1().setComment("test comment");
            root.getID3V1().setYear("2019");

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
