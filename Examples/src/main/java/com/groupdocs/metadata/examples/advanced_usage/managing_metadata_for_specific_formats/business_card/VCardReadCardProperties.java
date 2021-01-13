// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.business_card;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.VCardCard;
import com.groupdocs.metadata.core.VCardRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to read metadata properties of a vCard file.
 */
public class VCardReadCardProperties {

    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVcf)) {
            VCardRootPackage root = metadata.getRootPackageGeneric();

            for (VCardCard vCard : root.getVCardPackage().getCards()) {
                System.out.println(vCard.getIdentificationRecordset().getName());
                PrintArray(vCard.getIdentificationRecordset().getFormattedNames());
                PrintArray(vCard.getCommunicationRecordset().getEmails());
                PrintArray(vCard.getCommunicationRecordset().getTelephones());
                PrintArray(vCard.getDeliveryAddressingRecordset().getAddresses());

                // ...
            }
        }
    }

    private static void PrintArray(String[] values) {
        if (values != null) {
            for (String value : values) {
                System.out.println(value);
            }
        }
    }
}
