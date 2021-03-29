// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EmailRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to update fields of an email message.
 */
public class EmailUpdateEmailFields {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputEml)) {
            EmailRootPackage root = metadata.getRootPackageGeneric();

            root.getEmailPackage().setRecipients(new String[] { "sample@aspose.com" });
            root.getEmailPackage().setCarbonCopyRecipients(new String[] { "sample@groupdocs.com" });
            root.getEmailPackage().setSubject("RE: test subject");

            metadata.save(Constants.OutputEml);
        }
    }
}

