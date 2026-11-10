// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.loading_files;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import java.net.URI;

/**
 * This example demonstrates how to load a document from a web resource (URI).
 */
public class LoadFromUri {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # LoadFromUri : How to load metadata from a URI.\n");
        // The document is downloaded into memory and then loaded like a stream
        URI uri = URI.create("https://raw.githubusercontent.com/groupdocs-metadata/GroupDocs.Metadata-for-Java/master/Examples/Resources/SampleFiles/Input/exif.jpg");
        try (Metadata metadata = new Metadata(uri)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getFileType().getFileFormat());
            if (root.getExifPackage() != null) {
                System.out.println(root.getExifPackage().getMake());
                System.out.println(root.getExifPackage().getModel());
            }
        }
    }
}
