// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.core.IptcApplicationRecordDataSet;
import com.groupdocs.metadata.core.IptcDataSet;
import com.groupdocs.metadata.core.IptcRecordSet;
import com.groupdocs.metadata.core.IptcRecordType;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to add a repeatable DataSet to an IPTC IIM record.
 */
public class AddRepeatableIptcDataSet {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.PsdWithIptc)) {
            IIptc root = (IIptc)metadata.getRootPackage();
            
            // Set the IPTC package if it's missing
            if (root.getIptcPackage() == null) {
                root.setIptcPackage(new IptcRecordSet());
            }

            root.getIptcPackage().add(new IptcDataSet((byte)IptcRecordType.ApplicationRecord, (byte)IptcApplicationRecordDataSet.Keywords, "keyword 1"));
            root.getIptcPackage().add(new IptcDataSet((byte)IptcRecordType.ApplicationRecord, (byte)IptcApplicationRecordDataSet.Keywords, "keyword 2"));
            root.getIptcPackage().add(new IptcDataSet((byte)IptcRecordType.ApplicationRecord, (byte)IptcApplicationRecordDataSet.Keywords, "keyword 3"));

            metadata.save(Constants.OutputPsd);
        }
        
        // Check the output file
        try (Metadata metadata = new Metadata(Constants.OutputPsd)) {
            IIptc root = (IIptc)metadata.getRootPackage();
            MetadataProperty keywordsProperty = root.getIptcPackage().getApplicationRecord().get_Item((byte)IptcApplicationRecordDataSet.Keywords);

            for (PropertyValue value : keywordsProperty.getValue().toArray(PropertyValue.class)) {
                System.out.println(value);
            }
        }
    }
}
