// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.core.IptcDataSet;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to read IPTC IIM datasets from an IPTC metadata package.
 */
public class ReadIptcDataSets {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.PsdWithIptc)) {
            IIptc root = (IIptc) metadata.getRootPackage();
            if (root.getIptcPackage() != null) {
                for (IptcDataSet dataSet : root.getIptcPackage().toDataSetList()) {
                    System.out.println(dataSet.getRecordNumber());
                    System.out.println(dataSet.getDataSetNumber());
                    System.out.println(dataSet.getAlternativeName());
                    System.out.println(dataSet.getValue().getRawValue());
                }
            }
        }
    }
}
