// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.core.IptcApplicationRecord;
import com.groupdocs.metadata.core.IptcEnvelopeRecord;
import com.groupdocs.metadata.core.IptcRecordSet;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This code sample shows hot to update basic IPTC metadata properties.
 */
public class UpdateIptcProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputJpeg)) {
            IIptc root = (IIptc) metadata.getRootPackage();

            // Set the IPTC package if it's missing
            if (root.getIptcPackage() == null) {
                root.setIptcPackage(new IptcRecordSet());
            }

            if (root.getIptcPackage().getEnvelopeRecord() == null) {
                root.getIptcPackage().setEnvelopeRecord(new IptcEnvelopeRecord());
            }

            root.getIptcPackage().getEnvelopeRecord().setDateSent(new Date());
            root.getIptcPackage().getEnvelopeRecord().setProductID("test project id");

            // ...

            if (root.getIptcPackage().getApplicationRecord() == null) {
                root.getIptcPackage().setApplicationRecord(new IptcApplicationRecord());
            }

            root.getIptcPackage().getApplicationRecord().setByLine("GroupDocs");
            root.getIptcPackage().getApplicationRecord().setHeadline("test");
            root.getIptcPackage().getApplicationRecord().setByLineTitle("code sample");
            root.getIptcPackage().getApplicationRecord().setReleaseDate(new Date());

            // ...

            metadata.save(Constants.OutputJpeg);
        }
    }
}
