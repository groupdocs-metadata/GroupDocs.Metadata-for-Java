package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.dng;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DngRootPackage;

import java.nio.file.Path;

/**
 * This code snippet shows how to detect the version of a loaded DNG image and extract some additional file format information.
 */
public class DngReadFileFormatProperties {
    public static DngRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            DngRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Format: %s%n", root.getImageType().getFileFormat());
            System.out.printf("\tByte Order: %s%n", root.getImageType().getByteOrder());
            System.out.printf("\tMIME Type: %s%n", root.getImageType().getMimeType());
            System.out.printf("\tExtension: %s%n", root.getImageType().getExtension());
            System.out.printf("\tWidth: %d%n", root.getImageType().getWidth());
            System.out.printf("\tHeight: %d%n", root.getImageType().getHeight());
            System.out.printf("\tArtist: %s%n", root.getDngPackage().getArtist());
            System.out.printf("\tDescription: %s%n", root.getDngPackage().getDescription());
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }

}
