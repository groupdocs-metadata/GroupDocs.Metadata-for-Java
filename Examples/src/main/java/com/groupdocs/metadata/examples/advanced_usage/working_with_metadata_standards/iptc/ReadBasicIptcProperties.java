// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to read basic IPTC metadata properties.
 */
public class ReadBasicIptcProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithIptc)) {
            IIptc root = (IIptc) metadata.getRootPackage();
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
