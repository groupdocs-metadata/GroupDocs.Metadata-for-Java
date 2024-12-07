// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.bmp;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.BmpRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to read the header of a BMP file.
 */
public class BmpReadHeaderProperties {
    public static BmpRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            BmpRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tBits per pixel: %d%n", root.getBmpHeader().getBitsPerPixel());
            System.out.printf("\tColors important: %d%n", root.getBmpHeader().getColorsImportant());
            System.out.printf("\tHeader size: %d%n", root.getBmpHeader().getHeaderSize());
            System.out.printf("\tImage size: %d%n", root.getBmpHeader().getImageSize());
            System.out.printf("\tPlanes: %d%n", root.getBmpHeader().getPlanes());
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
