// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ZipFile;
import com.groupdocs.metadata.core.ZipRootPackage;
import com.groupdocs.metadata.examples.Constants;

import java.nio.charset.Charset;

/**
 * The following code snippet shows how to get metadata from a ZIP archive.
 */
public class ZipReadNativeMetadataProperties {
    public static void run() {
        Charset charset = Charset.forName("cp866");

        try (Metadata metadata = new Metadata(Constants.InputZip)) {
            ZipRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getZipPackage().getComment());
            System.out.println(root.getZipPackage().getTotalEntries());

            for (ZipFile file : root.getZipPackage().getFiles()) {
                System.out.println(file.getName());
                System.out.println(file.getCompressedSize());
                System.out.println(file.getCompressionMethod());
                System.out.println(file.getFlags());
                System.out.println(file.getModificationDateTime());
                System.out.println(file.getUncompressedSize());

                // Use a specific encoding for the file names
                System.out.println(new String(file.getRawName(), charset));
            }
        }
    }
}
