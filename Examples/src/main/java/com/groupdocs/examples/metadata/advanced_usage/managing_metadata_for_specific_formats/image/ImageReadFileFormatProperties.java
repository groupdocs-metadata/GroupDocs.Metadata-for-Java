// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ImageRootPackage;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to extract common image properties such as width and height, MIME type, byte order, etc.
 */
public class ImageReadFileFormatProperties {
    public static ImageRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            ImageRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Format: %s%n", root.getImageType().getFileFormat());
            System.out.printf("\tByte Order: %s%n", root.getImageType().getByteOrder());
            System.out.printf("\tMime Type: %s%n", root.getImageType().getMimeType());
            System.out.printf("\tExtension: %s%n", root.getImageType().getExtension());
            System.out.printf("\tWidth: %d%n", root.getImageType().getWidth());
            System.out.printf("\tHeight: %d%n", root.getImageType().getHeight());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
