// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.core.IptcDataSet;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.core.PropertyValue;

import java.nio.file.Path;

/**
 * This example demonstrates how to read IPTC IIM datasets from an IPTC metadata package.
 */
public class ReadIptcDataSets {
    public static IIptc run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IIptc root = (IIptc) metadata.getRootPackage();
            if (root.getIptcPackage() != null) {
                for (IptcDataSet dataSet : root.getIptcPackage().toDataSetList()) {
                    System.out.printf("\tRecord Number: %s%n", dataSet.getRecordNumber());
                    System.out.printf("\tData Set Number: %s%n", dataSet.getDataSetNumber());
                    System.out.printf("\tAlternative Name: %s%n", dataSet.getAlternativeName());
                    if (dataSet.getValue().getType() == MetadataPropertyType.PropertyValueArray) {
                        for (PropertyValue value : dataSet.getValue().toArray(PropertyValue.class)) {
                            System.out.printf("\t\tValue: %s, ", value.getRawValue());
                        }
                        System.out.println();
                    } else {
                        System.out.printf("\tValue: %s%n", dataSet.getValue().getRawValue());
                    }
                }
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
