// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to add or update custom IPTC datasets in a file.
 */
public class SetCustomIptcDataSet {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.PsdWithIptc)) {
            IIptc root = (IIptc) metadata.getRootPackage();

            // Set the IPTC package if it's missing
            if (root.getIptcPackage() == null) {
                root.setIptcPackage(new IptcRecordSet());
            }

            // Add a know property using the DataSet API
            root.getIptcPackage().set(new IptcDataSet((byte) IptcRecordType.ApplicationRecord, (byte) IptcApplicationRecordDataSet.BylineTitle, "test code sample"));

            // Add a custom IPTC DataSet
            root.getIptcPackage().set(new IptcDataSet((byte) 100, (byte) 100, new byte[]{1, 2, 3}));

            metadata.save(Constants.OutputPsd);
        }
    }
}
