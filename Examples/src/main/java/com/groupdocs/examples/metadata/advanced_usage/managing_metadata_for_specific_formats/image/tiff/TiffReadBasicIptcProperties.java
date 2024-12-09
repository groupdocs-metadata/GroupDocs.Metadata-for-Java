// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.tiff;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TiffRootPackage;

import java.nio.file.Path;

/**
 * This example shows how to extract basic IPTC metadata properties from a TIFF image.
 */
public class TiffReadBasicIptcProperties {
    public static TiffRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            TiffRootPackage root = metadata.getRootPackageGeneric();
            if (root.getIptcPackage() != null) {
                if (root.getIptcPackage().getEnvelopeRecord() != null) {
                    System.out.printf("\tDate Sent: %s%n", root.getIptcPackage().getEnvelopeRecord().getDateSent());
                    System.out.printf("\tDestination: %s%n", root.getIptcPackage().getEnvelopeRecord().getDestination());
                    System.out.printf("\tFile Format: %s%n", root.getIptcPackage().getEnvelopeRecord().getFileFormat());
                    System.out.printf("\tFile Format Version: %s%n", root.getIptcPackage().getEnvelopeRecord().getFileFormatVersion());
                }
                if (root.getIptcPackage().getApplicationRecord() != null) {
                    System.out.printf("\tHeadline: %s%n", root.getIptcPackage().getApplicationRecord().getHeadline());
                    System.out.printf("\tByLine: %s%n", root.getIptcPackage().getApplicationRecord().getByLine());
                    System.out.printf("\tByLine Title: %s%n", root.getIptcPackage().getApplicationRecord().getByLineTitle());
                    System.out.printf("\tCaption Abstract: %s%n", root.getIptcPackage().getApplicationRecord().getCaptionAbstract());
                    System.out.printf("\tCity: %s%n", root.getIptcPackage().getApplicationRecord().getCity());
                    System.out.printf("\tDate Created: %s%n", root.getIptcPackage().getApplicationRecord().getDateCreated());
                    System.out.printf("\tRelease Date: %s%n", root.getIptcPackage().getApplicationRecord().getReleaseDate());
                }
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
