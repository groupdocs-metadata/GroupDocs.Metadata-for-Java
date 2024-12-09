// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.business_card;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.VCardCard;
import com.groupdocs.metadata.core.VCardRootPackage;

import java.nio.file.Path;
import java.util.Arrays;

/**
 * This class demonstrates how to use vCard property filters to extract specific information from vCard files.
 */
public class VCardFilterCardProperties {
    /**
     * Filters and extracts work-related preferred properties from the specified vCard file.
     *
     * @param inputFile The path to the input vCard file from which to filter and extract properties.
     * @return The root package containing the filtered vCard information.
     */
    public static VCardRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            VCardRootPackage root = metadata.getRootPackageGeneric();

            for (VCardCard vCard : root.getVCardPackage().getCards()) {
                VCardCard filtered = vCard.filterWorkTags().filterPreferred();
                System.out.printf("\tTelephones: %s%n", Arrays.toString(filtered.getCommunicationRecordset().getTelephones()));
                System.out.printf("\tEmails: %s%n", Arrays.toString(filtered.getCommunicationRecordset().getEmails()));
            }

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
