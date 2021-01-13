// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.video.avi;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.AviRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract INFO chunk metadata from an AVI file.
 */
public class AviReadInfoMetadata {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputAvi)) {
            AviRootPackage root = metadata.getRootPackageGeneric();
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
