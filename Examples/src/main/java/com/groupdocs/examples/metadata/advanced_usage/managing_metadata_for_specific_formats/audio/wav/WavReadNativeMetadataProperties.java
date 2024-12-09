// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.wav;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WavRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class provides functionality to extract technical audio information from a WAV file.
 */
public class WavReadNativeMetadataProperties {
    /**
     * Extracts the technical audio information from the specified WAV file.
     *
     * @param inputFile The path to the input WAV file from which to extract the metadata.
     * @return The root package containing the extracted audio information.
     */
    public static WavRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WavRootPackage root = metadata.getRootPackageGeneric();
            if (root.getWavPackage() != null) {
                System.out.printf("\tAudio Format: %s%n", root.getWavPackage().getAudioFormat());
                System.out.printf("\tBits Per Sample: %d%n", root.getWavPackage().getBitsPerSample());
                System.out.printf("\tBlock Align: %d%n", root.getWavPackage().getBlockAlign());
                System.out.printf("\tByte Rate: %d%n", root.getWavPackage().getByteRate());
                System.out.printf("\tNumber of Channels: %d%n", root.getWavPackage().getNumberOfChannels());
                System.out.printf("\tSample Rate: %d%n", root.getWavPackage().getSampleRate());
            } else {
                System.out.println("\tWav Package data not found.");
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
