// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.wav;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WavRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract technical audio information from a WAV file.
 */
public class WavReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputWav)) {
            WavRootPackage root = metadata.getRootPackageGeneric();
            if (root.getWavPackage() != null) {
                System.out.println(root.getWavPackage().getAudioFormat());
                System.out.println(root.getWavPackage().getBitsPerSample());
                System.out.println(root.getWavPackage().getBlockAlign());
                System.out.println(root.getWavPackage().getByteRate());
                System.out.println(root.getWavPackage().getNumberOfChannels());
                System.out.println(root.getWavPackage().getSampleRate());
            }
        }
    }
}
