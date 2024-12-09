// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ZipFile;
import com.groupdocs.metadata.core.ZipRootPackage;

import java.nio.charset.Charset;
import java.nio.file.Path;

/**
 * Provides a method to read metadata from a ZIP archive.
 */
public class ZipReadNativeMetadataProperties {

    /**
     * Extracts and prints metadata from a ZIP archive.
     *
     * @param inputZip The path to the ZIP archive file.
     * @return The root package of the ZIP archive, or null if an error occurred.
     */
    public static ZipRootPackage run(Path inputZip) {
        final Charset charset = Charset.forName("cp866"); // Specifies the character encoding for raw file names
        try (Metadata metadata = new Metadata(inputZip.toString())) {
            ZipRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("Zip comment: %s%n", root.getZipPackage().getComment());
            System.out.printf("Total entries: %d%n", root.getZipPackage().getTotalEntries());

            for (ZipFile file : root.getZipPackage().getFiles()) {
                System.out.printf("\tFile name: %s%n", file.getName());
                System.out.printf("\tCompressed size: %d%n", file.getCompressedSize());
                System.out.printf("\tCompression method: %s%n", file.getCompressionMethod());
                System.out.printf("\tFlags: %d%n", file.getFlags());
                System.out.printf("\tModification date time: %s%n", file.getModificationDateTime());
                System.out.printf("\tUncompressed size: %d%n", file.getUncompressedSize());
                System.out.printf("\tRaw name: %s%n", new String(file.getRawName(), charset));
            }

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
