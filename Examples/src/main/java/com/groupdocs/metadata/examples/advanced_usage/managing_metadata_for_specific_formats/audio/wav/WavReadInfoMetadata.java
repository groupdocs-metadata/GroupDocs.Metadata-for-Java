// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.wav;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WavRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract INFO chunk metadata from a WAV file.
 */
public class WavReadInfoMetadata {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputWav)) {
            WavRootPackage root = metadata.getRootPackageGeneric();
            if (root.getRiffInfoPackage() != null) {
                System.out.println(root.getRiffInfoPackage().getArtist());
                System.out.println(root.getRiffInfoPackage().getComment());
                System.out.println(root.getRiffInfoPackage().getCopyright());
                System.out.println(root.getRiffInfoPackage().getCreationDate());
                System.out.println(root.getRiffInfoPackage().getSoftware());
                System.out.println(root.getRiffInfoPackage().getEngineer());
                System.out.println(root.getRiffInfoPackage().getGenre());

                // ...
            }
        }
    }
}
