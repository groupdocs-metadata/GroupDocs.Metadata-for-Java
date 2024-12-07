// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.peer2peer;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TorrentRootPackage;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to update metadata in a TORRENT file.
 */
public class TorrentUpdateNativeMetadataProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("ModifiedTorrentInfo.torrent");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            TorrentRootPackage root = metadata.getRootPackageGeneric();
            root.getTorrentPackage().setComment("test comment");
            root.getTorrentPackage().setCreatedBy("GroupDocs.Metadata");
            root.getTorrentPackage().setCreationDate(new Date());

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
