// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.peer2peer;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TorrentRootPackage;
import com.groupdocs.metadata.core.TorrentSharedFilePackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read metadata of a TORRENT file.
 */
public class TorrentReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputTorrent)) {
            TorrentRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getTorrentPackage().getAnnounce());
            System.out.println(root.getTorrentPackage().getComment());
            System.out.println(root.getTorrentPackage().getCreatedBy());
            System.out.println(root.getTorrentPackage().getCreationDate());
            for (TorrentSharedFilePackage file : root.getTorrentPackage().getSharedFiles()) {
                System.out.println(file.getName());
                System.out.println(file.getLength());
            }

            // ...
        }
    }
}
