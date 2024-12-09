// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MP3RootPackage;

import java.nio.file.Path;

/**
 * This class demonstrates how to read MPEG audio metadata from an MP3 file.
 */
public class MP3ReadMpegAudioMetadata {
    /**
     * This method reads MPEG audio metadata from the specified MP3 file.
     *
     * @param inputFile The path to the input MP3 file containing the MPEG audio metadata.
     * @return The root package of the MP3 file, or null if an error occurred.
     */
    public static MP3RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MP3RootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tBitrate: %s%n", root.getMpegAudioPackage().getBitrate());
            System.out.printf("\tChannel Mode: %s%n", root.getMpegAudioPackage().getChannelMode());
            System.out.printf("\tEmphasis: %s%n", root.getMpegAudioPackage().getEmphasis());
            System.out.printf("\tFrequency: %s%n", root.getMpegAudioPackage().getFrequency());
            System.out.printf("\tHeader Position: %s%n", root.getMpegAudioPackage().getHeaderPosition());
            System.out.printf("\tLayer: %s%n", root.getMpegAudioPackage().getLayer());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
