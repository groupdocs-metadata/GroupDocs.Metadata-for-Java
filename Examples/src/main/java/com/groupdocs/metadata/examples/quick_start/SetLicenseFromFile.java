// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.quick_start;

import com.groupdocs.metadata.licensing.License;
import com.groupdocs.metadata.examples.Constants;

import java.io.File;

/**
 * This example demonstrates how to set license from file.
 * <p>
 * The SetLicense method attempts to set a license from several locations relative to the executable and GroupDocs.Viewer.dll.
 * You can also use the additional overload to load a license from a stream, this is useful for instance when the
 * License is stored as an embedded resource.
 **/
public class SetLicenseFromFile {
    public static void run() {
        File licenseFile = new File(Constants.LicenseFilePath);
        if (licenseFile.exists()) {
            License license = new License();
            license.setLicense(licenseFile.getPath());

            System.out.println("License set successfully.");
        } else {
            System.out.println("\nWe do not ship any license with this example. " +
                    "\nVisit the GroupDocs site to obtain either a temporary or permanent license. " +
                    "\nLearn more about licensing at https://purchase.groupdocs.com/faqs/licensing. " +
                    "\nLear how to request temporary license at https://purchase.groupdocs.com/temporary-license.");
        }
    }
}
