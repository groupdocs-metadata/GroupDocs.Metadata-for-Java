package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.RarFile;
import com.groupdocs.metadata.core.RarRootPackage;

import java.nio.file.Path;

/**
 * The following code snippet shows how to get metadata from a Rar archive.
 */
public class RarReadNativeMetadataProperties {
    public static RarRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            RarRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tTotal entries in archive: %s%n", root.getRarPackage().getTotalEntries());
            for (RarFile file : root.getRarPackage().getFiles()) {
                System.out.printf("\tFile name: %s%n", file.getName());
                System.out.printf("\tCompressed size: %s%n", file.getCompressedSize());
                System.out.printf("\tModification date time: %s%n", file.getModificationDateTime());
                System.out.printf("\tUncompressed size: %s%n", file.getUncompressedSize());
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
