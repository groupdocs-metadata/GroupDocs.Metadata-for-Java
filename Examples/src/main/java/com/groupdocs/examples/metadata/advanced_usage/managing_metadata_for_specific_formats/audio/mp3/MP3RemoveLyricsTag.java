// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class provides functionality to remove the Lyrics3v2 tag from an MP3 file.
 */
public class MP3RemoveLyricsTag {
    /**
     * Removes the Lyrics3v2 tag from the specified MP3 file and saves the modified MP3 file.
     *
     * @param inputFile The path to the input MP3 file from which to remove the Lyrics3v2 tag.
     * @return The path to the modified MP3 file saved in the output directory.
     */
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("MP3WithoutLyrics.mp3");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();

            root.setLyrics3V2(null);

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
