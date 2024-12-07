// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.psd;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ImageResourceBlock;
import com.groupdocs.metadata.core.PsdRootPackage;

import java.nio.file.Path;
import java.util.Arrays;

/**
 * The code sample below demonstrates how to extract image resource blocks (building blocks of the Photoshop file format) from a PSD image.
 */
public class PsdReadImageResourceBlocks {
    public static PsdRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PsdRootPackage root = metadata.getRootPackageGeneric();
            if (root.getImageResourcePackage() != null) {
                for (ImageResourceBlock block : root.getImageResourcePackage().toList()) {
                    System.out.printf("\tSignature: %s%n", block.getSignature());
                    System.out.printf("\tID: %s%n", block.getID());
                    System.out.printf("\tName: %s%n", block.getName());
                    System.out.printf("\tData: %s%n", Arrays.toString(block.getData()).substring(0, Math.min(20, block.getData().length)));
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
