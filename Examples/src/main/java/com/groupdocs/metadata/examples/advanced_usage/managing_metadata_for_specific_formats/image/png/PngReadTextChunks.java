// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.png;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PngCompressedTextChunk;
import com.groupdocs.metadata.core.PngInternationalTextChunk;
import com.groupdocs.metadata.core.PngRootPackage;
import com.groupdocs.metadata.core.PngTextChunk;
import com.groupdocs.metadata.examples.Constants;

/**
 *
 * This code snippet shows how to extract chunks of textual metadata from a PNG
 * image.
 */
public class PngReadTextChunks {

    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPng)) {
            PngRootPackage root = metadata.getRootPackageGeneric();

            for (PngTextChunk chunk : root.getPngPackage().getTextChunks()) {
                System.out.println(chunk.getKeyword());
                System.out.println(chunk.getText());

                if (chunk instanceof PngCompressedTextChunk) {
                    PngCompressedTextChunk compressedChunk = (PngCompressedTextChunk) chunk;
                    System.out.println(compressedChunk.getCompressionMethod());
                }

                if (chunk instanceof PngInternationalTextChunk) {
                    PngInternationalTextChunk internationalChunk = (PngInternationalTextChunk) chunk;
                    System.out.println(internationalChunk.isCompressed());
                    System.out.println(internationalChunk.getLanguage());
                    System.out.println(internationalChunk.getTranslatedKeyword());
                }
            }
        }
    }
}
