// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.TiffTag;

import java.nio.file.Path;


/**
 * This code sample shows how to extract all detected MakerNote properties in the form of TIFF/EXIF tags.
 */
public class MakerNoteReadAllTags {
    public static JpegRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            if (root.getMakerNotePackage() != null) {
                for (TiffTag tag : root.getMakerNotePackage().toList()) {
                    System.out.printf("\t%s = %s%n", tag.getTagID(), tag.getValue());
                }
            } else {
                System.out.println("\tMaker Note Package not found.");
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}