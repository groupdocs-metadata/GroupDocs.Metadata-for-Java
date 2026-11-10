// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.audio.ogg;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.OggRootPackage;
import com.groupdocs.metadata.core.OggUserComment;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read metadata of an OGG Vorbis file.
 */
public class OggReadNativeMetadataProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # OggReadNativeMetadataProperties : How to read metadata of an OGG file.\n");
        try (Metadata metadata = new Metadata(Constants.InputOgg)) {
            OggRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getOggPackage().getVendor());
            System.out.println(root.getOggPackage().getTitle());
            System.out.println(root.getOggPackage().getArtist());
            System.out.println(root.getOggPackage().getCopyright());
            System.out.println(root.getOggPackage().getDate());

            // Vorbis comments that are not mapped to dedicated properties
            for (OggUserComment comment : root.getOggPackage().getOggUserComments()) {
                System.out.println(comment.getHeader());
                System.out.println(comment.getValue());
            }
        }
    }
}
