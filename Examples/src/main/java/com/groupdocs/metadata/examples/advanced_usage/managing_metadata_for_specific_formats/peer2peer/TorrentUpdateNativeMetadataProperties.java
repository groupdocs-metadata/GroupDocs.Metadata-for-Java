// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.peer2peer;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TorrentRootPackage;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This code sample shows how to update metadata in a TORRENT file.
 */
public class TorrentUpdateNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputTorrent)) {
            TorrentRootPackage root = metadata.getRootPackageGeneric();

            root.getTorrentPackage().setComment("test comment");
            root.getTorrentPackage().setCreatedBy("GroupDocs.Metadata");
            root.getTorrentPackage().setCreationDate(new Date());

            metadata.save(Constants.OutputTorrent);
        }
    }
}
