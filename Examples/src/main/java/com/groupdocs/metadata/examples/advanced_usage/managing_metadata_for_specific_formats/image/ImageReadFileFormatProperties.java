// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ImageRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to extract common image properties such as width and height, MIME type, byte order, etc.
 */
public class ImageReadFileFormatProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPng)) {
            ImageRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getImageType().getFileFormat());
            System.out.println(root.getImageType().getByteOrder());
            System.out.println(root.getImageType().getMimeType());
            System.out.println(root.getImageType().getExtension());
            System.out.println(root.getImageType().getWidth());
            System.out.println(root.getImageType().getHeight());
        }
    }
}
