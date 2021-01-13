// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.gif;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.GifRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet shows how to detect the version of a loaded GIF image and extract some additional file format information.
 */
public class GifReadFileFormatProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputGif)) {
            GifRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getGifImageType().getFileFormat());
            System.out.println(root.getGifImageType().getVersion());
            System.out.println(root.getGifImageType().getByteOrder());
            System.out.println(root.getGifImageType().getMimeType());
            System.out.println(root.getGifImageType().getExtension());
            System.out.println(root.getGifImageType().getWidth());
            System.out.println(root.getGifImageType().getHeight());
        }
    }
}
