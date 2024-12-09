package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TarFile;
import com.groupdocs.metadata.core.TarRootPackage;

import java.nio.file.Path;

/**
 * Provides a method to read metadata from a Tar archive.
 */
public class TarReadNativeMetadataProperties {

    /**
     * Extracts and prints metadata from a Tar archive.
     *
     * @param inputFile The path to the Tar archive file.
     * @return The root package of the Tar archive, or null if an error occurred.
     */
    public static TarRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            TarRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tTotal entries in archive: %s%n", root.getTarPackage().getTotalEntries());

            for (TarFile file : root.getTarPackage().getFiles()) {
                System.out.printf("\tFile name: %s%n", file.getName());
                System.out.printf("\tFile size: %s%n", file.getSize());
            }

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}