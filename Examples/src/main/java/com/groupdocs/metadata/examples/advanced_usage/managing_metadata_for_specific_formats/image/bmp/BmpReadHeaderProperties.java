// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.bmp;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.BmpRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read the header of a BMP file.
 */
public class BmpReadHeaderProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputBmp)) {
            BmpRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getBmpHeader().getBitsPerPixel());
            System.out.println(root.getBmpHeader().getColorsImportant());
            System.out.println(root.getBmpHeader().getHeaderSize());
            System.out.println(root.getBmpHeader().getImageSize());
            System.out.println(root.getBmpHeader().getPlanes());
        }
    }
}
