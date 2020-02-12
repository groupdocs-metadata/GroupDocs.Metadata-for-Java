// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.business_card;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.VCardCard;
import com.groupdocs.metadata.core.VCardRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to use vCard property filters.
 */
public class VCardFilterCardProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVcf)) {
            VCardRootPackage root = metadata.getRootPackageGeneric();

            for (VCardCard vCard : root.getVCardPackage().getCards()) {
                // Print most preferred work phone numbers and work emails
                VCardCard filtered = vCard.filterWorkTags().filterPreferred();
                PrintArray(filtered.getCommunicationRecordset().getTelephones());
                PrintArray(filtered.getCommunicationRecordset().getEmails());
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
