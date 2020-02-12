// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.business_card;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.VCardCard;
import com.groupdocs.metadata.core.VCardRootPackage;
import com.groupdocs.metadata.core.VCardTextRecord;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to extract vCard fields along with descriptive parameters.
 */
public class VCardReadCardPropertiesWithParameters {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVcf)) {
            VCardRootPackage root = metadata.getRootPackageGeneric();

            for (VCardCard vCard : root.getVCardPackage().getCards()) {
                if (vCard.getIdentificationRecordset().getPhotoUriRecords() != null) {
                    // Iterate all photos represented by URIs
                    for (VCardTextRecord photoUriRecord : vCard.getIdentificationRecordset().getPhotoUriRecords()) {
                        // Print the property value
                        System.out.println(photoUriRecord.getValue());

                        // Print some additional parameters of the property
                        System.out.println(photoUriRecord.getContentType());
                        System.out.println(photoUriRecord.getMediaTypeParameter());
                        if (photoUriRecord.getTypeParameters() != null) {
                            for (String parameter : photoUriRecord.getTypeParameters()) {
                                System.out.println(parameter);
                            }
                        }
                        System.out.println(photoUriRecord.getPrefParameter());
                    }
                }
            }
        }
    }
}
