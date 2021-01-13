// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.quick_start;

import com.groupdocs.metadata.licensing.License;
import com.groupdocs.metadata.examples.Constants;

import java.io.*;

/**
 * This example demonstrates how to set license from stream.
 **/
public class SetLicenseFromStream {
    public static void run() throws IOException {
        File licenseFile = new File(Constants.LicenseFilePath);
        if (licenseFile.exists()) {
            try (InputStream stream = new FileInputStream(licenseFile.getPath())) {
                License license = new License();
                license.setLicense(stream);
            }

            System.out.println("License set successfully.");
        } else {
            System.out.println("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}
