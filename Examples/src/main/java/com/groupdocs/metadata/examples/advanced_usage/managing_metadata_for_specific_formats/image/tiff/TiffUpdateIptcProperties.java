// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.tiff;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.core.IptcApplicationRecord;
import com.groupdocs.metadata.core.IptcEnvelopeRecord;
import com.groupdocs.metadata.core.IptcRecordSet;
import com.groupdocs.metadata.examples.Constants;
import java.util.Date;
import java.util.UUID;

/**
 * This code sample demonstrates how to update IPTC metadata properties in a TIFF image.
 */
public class TiffUpdateIptcProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # TiffUpdateIptcProperties : How to update IPTC metadata properties in a TIFF image.\n");
        try (Metadata metadata = new Metadata(Constants.TiffWithIptc)) {
            IIptc root = (IIptc) metadata.getRootPackage();

            // Set the IPTC package if it's missing
            if (root.getIptcPackage() == null) {
                root.setIptcPackage(new IptcRecordSet());
            }

            if (root.getIptcPackage().getEnvelopeRecord() == null) {
                root.getIptcPackage().setEnvelopeRecord(new IptcEnvelopeRecord());
            }
            root.getIptcPackage().getEnvelopeRecord().setDateSent(new Date());
            root.getIptcPackage().getEnvelopeRecord().setProductID(UUID.randomUUID().toString());

            // ...

            if (root.getIptcPackage().getApplicationRecord() == null) {
                root.getIptcPackage().setApplicationRecord(new IptcApplicationRecord());
            }
            root.getIptcPackage().getApplicationRecord().setByLine("GroupDocs");
            root.getIptcPackage().getApplicationRecord().setHeadline("test headline");
            root.getIptcPackage().getApplicationRecord().setByLineTitle("code sample");
            root.getIptcPackage().getApplicationRecord().setReleaseDate(new Date());
            root.getIptcPackage().getApplicationRecord().setCity("New York");
            root.getIptcPackage().getApplicationRecord().setCaptionAbstract("test caption");

            // ...

            metadata.save(Constants.OutputTiff);
        }
    }
}
