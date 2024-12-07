// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.png;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PngCompressedTextChunk;
import com.groupdocs.metadata.core.PngInternationalTextChunk;
import com.groupdocs.metadata.core.PngRootPackage;
import com.groupdocs.metadata.core.PngTextChunk;

import java.nio.file.Path;

/**
 * This code snippet shows how to extract chunks of textual metadata from a PNG
 * image.
 */
public class PngReadTextChunks {
    public static PngRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PngRootPackage root = metadata.getRootPackageGeneric();
            for (PngTextChunk chunk : root.getPngPackage().getTextChunks()) {
                System.out.printf("\tKeyword: %s%n", chunk.getKeyword());
                final String chunkText = chunk.getText();
                System.out.printf("\tText: %s%n", chunkText.substring(0, Math.min(chunkText.length(), 50)) + "...");
                if (chunk instanceof PngCompressedTextChunk) {
                    PngCompressedTextChunk compressedChunk = (PngCompressedTextChunk) chunk;
                    System.out.printf("\t\tCompression Method: %s%n", compressedChunk.getCompressionMethod());
                }
                if (chunk instanceof PngInternationalTextChunk) {
                    PngInternationalTextChunk internationalChunk = (PngInternationalTextChunk) chunk;
                    System.out.printf("\t\tCompressed: %s%n", internationalChunk.isCompressed());
                    System.out.printf("\t\tLanguage: %s%n", internationalChunk.getLanguage());
                    System.out.printf("\t\tTranslated Keyword: %s%n", internationalChunk.getTranslatedKeyword());
                }
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
