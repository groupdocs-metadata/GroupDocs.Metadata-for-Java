// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.wav;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WavRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class provides functionality to extract INFO chunk metadata from a WAV file.
 */
public class WavReadInfoMetadata {
    /**
     * Extracts the INFO chunk metadata from the specified WAV file.
     *
     * @param inputFile The path to the input WAV file from which to extract the metadata.
     * @return The root package containing the extracted metadata.
     */
    public static WavRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WavRootPackage root = metadata.getRootPackageGeneric();
            if (root.getRiffInfoPackage() != null) {
                System.out.printf("\tArtist: %s%n", root.getRiffInfoPackage().getArtist());
                System.out.printf("\tComment: %s%n", root.getRiffInfoPackage().getComment());
                System.out.printf("\tCopyright: %s%n", root.getRiffInfoPackage().getCopyright());
                System.out.printf("\tCreation Date: %s%n", root.getRiffInfoPackage().getCreationDate());
                System.out.printf("\tSoftware: %s%n", root.getRiffInfoPackage().getSoftware());
                System.out.printf("\tEngineer: %s%n", root.getRiffInfoPackage().getEngineer());
                System.out.printf("\tGenre: %s%n", root.getRiffInfoPackage().getGenre());
            } else {
                System.out.println("\tRIFF Info data not found.");
            }

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
