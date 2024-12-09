// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.business_card;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.VCardCard;
import com.groupdocs.metadata.core.VCardRootPackage;
import com.groupdocs.metadata.core.VCardTextRecord;

import java.nio.file.Path;

/**
 * This class demonstrates how to extract vCard fields along with their descriptive parameters from a vCard file.
 */
public class VCardReadCardPropertiesWithParameters {
    /**
     * Extracts and displays vCard fields and their descriptive parameters from the specified vCard file.
     *
     * @param inputFile The path to the input vCard file from which to extract properties.
     * @return The root package containing the extracted vCard information.
     */
    public static VCardRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            VCardRootPackage root = metadata.getRootPackageGeneric();
            for (VCardCard vCard : root.getVCardPackage().getCards()) {
                if (vCard.getIdentificationRecordset().getPhotoUriRecords() != null) {
                    for (VCardTextRecord photoUriRecord : vCard.getIdentificationRecordset().getPhotoUriRecords()) {
                        System.out.printf("\tURI: %s%n", photoUriRecord.getValue());
                        System.out.printf("\tContent Type: %s%n", photoUriRecord.getContentType());
                        System.out.printf("\tMedia Type Parameter: %s%n", photoUriRecord.getMediaTypeParameter());
                        if (photoUriRecord.getTypeParameters() != null) {
                            for (String parameter : photoUriRecord.getTypeParameters()) {
                                System.out.printf("\t\tParameter: %s%n", parameter);
                            }
                        }
                        System.out.printf("\tPref Parameter: %s%n", photoUriRecord.getPrefParameter());
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
