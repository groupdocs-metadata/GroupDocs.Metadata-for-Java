// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.peer2peer;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TorrentRootPackage;
import com.groupdocs.metadata.core.TorrentSharedFilePackage;

import java.nio.file.Path;

/**
 * This code sample shows how to read metadata of a TORRENT file.
 */
public class TorrentReadNativeMetadataProperties {
    public static TorrentRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            TorrentRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tAnnounce: %s%n", root.getTorrentPackage().getAnnounce());
            System.out.printf("\tComment: %s%n", root.getTorrentPackage().getComment());
            System.out.printf("\tCreated By: %s%n", root.getTorrentPackage().getCreatedBy());
            System.out.printf("\tCreation Date: %s%n", root.getTorrentPackage().getCreationDate());
            for (TorrentSharedFilePackage file : root.getTorrentPackage().getSharedFiles()) {
                System.out.printf("\t\tName: %s%n", file.getName());
                System.out.printf("\t\tLength: %d%n", file.getLength());
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
