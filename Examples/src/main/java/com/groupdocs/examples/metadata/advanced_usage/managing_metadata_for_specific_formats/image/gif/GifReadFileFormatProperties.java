// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.gif;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.GifRootPackage;

import java.nio.file.Path;

/**
 * This code snippet shows how to detect the version of a loaded GIF image and extract some additional file format information.
 */
public class GifReadFileFormatProperties {
    public static GifRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            GifRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Format: %s%n", root.getGifImageType().getFileFormat());
            System.out.printf("\tVersion: %s%n", root.getGifImageType().getVersion());
            System.out.printf("\tByte Order: %s%n", root.getGifImageType().getByteOrder());
            System.out.printf("\tMIME Type: %s%n", root.getGifImageType().getMimeType());
            System.out.printf("\tExtension: %s%n", root.getGifImageType().getExtension());
            System.out.printf("\tWidth: %d%n", root.getGifImageType().getWidth());
            System.out.printf("\tHeight: %d%n", root.getGifImageType().getHeight());
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
