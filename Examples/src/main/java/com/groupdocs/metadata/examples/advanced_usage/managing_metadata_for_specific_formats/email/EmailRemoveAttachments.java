// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EmailRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to remove all attachments from an email.
 */
public class EmailRemoveAttachments {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputEml)) {
            EmailRootPackage root = metadata.getRootPackageGeneric();

            root.clearAttachments();

            metadata.save(Constants.OutputEml);
        }
    }
}
