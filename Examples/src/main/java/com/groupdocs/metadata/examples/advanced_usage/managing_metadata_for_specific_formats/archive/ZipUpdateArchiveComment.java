// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ZipRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code snippet shows how to update the user comment in a ZIP archive.
 */
public class ZipUpdateArchiveComment {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputZip)) {
            ZipRootPackage root = metadata.getRootPackageGeneric();

            root.getZipPackage().setComment("updated comment");

            metadata.save(Constants.OutputZip);
        }
    }
}
