// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg2000;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.Jpeg2000RootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code snippet demonstrates how to read JPEG2000 image comments.
 */
public class Jpeg2000ReadComments {
    public static Jpeg2000RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            Jpeg2000RootPackage root = metadata.getRootPackageGeneric();
            if (root.getJpeg2000Package().getComments() != null) {
                for (String comment : root.getJpeg2000Package().getComments()) {
                    System.out.printf("\t%s%n", comment);
                }
            } else {
                System.out.println("\tNo comments found.");
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
