// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.avi;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.AviRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to extract INFO chunk metadata from an AVI file.
 */
public class AviReadInfoMetadata {
    public static AviRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            AviRootPackage root = metadata.getRootPackageGeneric();
            if (root.getRiffInfoPackage() != null) {
                System.out.printf("\tArtist: %s%n", root.getRiffInfoPackage().getArtist());
                System.out.printf("\tComment: %s%n", root.getRiffInfoPackage().getComment());
                System.out.printf("\tCopyright: %s%n", root.getRiffInfoPackage().getCopyright());
                System.out.printf("\tCreation Date: %s%n", root.getRiffInfoPackage().getCreationDate());
                System.out.printf("\tSoftware: %s%n", root.getRiffInfoPackage().getSoftware());
                System.out.printf("\tEngineer: %s%n", root.getRiffInfoPackage().getEngineer());
                System.out.printf("\tGenre: %s%n", root.getRiffInfoPackage().getGenre());
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
