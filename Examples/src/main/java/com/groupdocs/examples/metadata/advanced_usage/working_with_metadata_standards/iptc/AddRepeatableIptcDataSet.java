// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to add a repeatable DataSet to an IPTC IIM record.
 */
public class AddRepeatableIptcDataSet {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("AddRepeatableIptcDataSet.psd");
        try {
            try (Metadata metadata = new Metadata(inputFile.toString())) {
                IIptc root = (IIptc) metadata.getRootPackage();
                // Set the IPTC package if it's missing
                if (root.getIptcPackage() == null) {
                    root.setIptcPackage(new IptcRecordSet());
                }
                root.getIptcPackage().add(new IptcDataSet((byte) IptcRecordType.ApplicationRecord.getRawValue(), (byte) IptcApplicationRecordDataSet.Keywords.getRawValue(), "keyword 1"));
                root.getIptcPackage().add(new IptcDataSet((byte) IptcRecordType.ApplicationRecord.getRawValue(), (byte) IptcApplicationRecordDataSet.Keywords.getRawValue(), "keyword 2"));
                root.getIptcPackage().add(new IptcDataSet((byte) IptcRecordType.ApplicationRecord.getRawValue(), (byte) IptcApplicationRecordDataSet.Keywords.getRawValue(), "keyword 3"));

                metadata.save(outputPath.toString());
            }

            try (Metadata metadata = new Metadata(outputPath.toString())) {
                IIptc root = (IIptc) metadata.getRootPackage();
                MetadataProperty keywordsProperty = root.getIptcPackage().getApplicationRecord().get_Item((byte) IptcApplicationRecordDataSet.Keywords.getRawValue());
                for (PropertyValue value : keywordsProperty.getValue().toArray(PropertyValue.class)) {
                    System.out.println("\tProperty value: " + value.getRawValue());
                }
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
