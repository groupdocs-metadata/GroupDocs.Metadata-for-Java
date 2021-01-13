// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.tiff;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TiffRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to extract basic IPTC metadata properties from a TIFF image.
 */
public class TiffReadBasicIptcProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.TiffWithIptc)) {
            TiffRootPackage root = metadata.getRootPackageGeneric();
            if (root.getIptcPackage() != null) {
                if (root.getIptcPackage().getEnvelopeRecord() != null) {
                    System.out.println(root.getIptcPackage().getEnvelopeRecord().getDateSent());
                    System.out.println(root.getIptcPackage().getEnvelopeRecord().getDestination());
                    System.out.println(root.getIptcPackage().getEnvelopeRecord().getFileFormat());
                    System.out.println(root.getIptcPackage().getEnvelopeRecord().getFileFormatVersion());

                    // ...
                }

                if (root.getIptcPackage().getApplicationRecord() != null) {
                    System.out.println(root.getIptcPackage().getApplicationRecord().getHeadline());
                    System.out.println(root.getIptcPackage().getApplicationRecord().getByLine());
                    System.out.println(root.getIptcPackage().getApplicationRecord().getByLineTitle());
                    System.out.println(root.getIptcPackage().getApplicationRecord().getCaptionAbstract());
                    System.out.println(root.getIptcPackage().getApplicationRecord().getCity());
                    System.out.println(root.getIptcPackage().getApplicationRecord().getDateCreated());
                    System.out.println(root.getIptcPackage().getApplicationRecord().getReleaseDate());

                    // ...
                }
            }
        }
    }
}
