package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SevenZipFile;
import com.groupdocs.metadata.core.SevenZipRootPackage;

import java.nio.file.Path;

/**
 * The following code snippet shows how to get metadata from a SevenZip archive.
 */
public class SevenZipReadNativeMetadataProperties {
    public static SevenZipRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            SevenZipRootPackage root = metadata.getRootPackageGeneric();
            System.out.println("\tTotal entries in archive: " + root.getSevenZipPackage().getTotalEntries());
            for (SevenZipFile file : root.getSevenZipPackage().getFiles()) {
                System.out.println("\tFile name: " + file.getName());
                System.out.println("\tCompressed size: " + file.getCompressedSize());
                System.out.println("\tModification date time: " + file.getModificationDateTime());
                System.out.println("\tUncompressed size: " + file.getUncompressedSize());
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
