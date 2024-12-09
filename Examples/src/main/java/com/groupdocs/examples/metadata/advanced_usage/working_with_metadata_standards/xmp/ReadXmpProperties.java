// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IXmp;

import java.nio.file.Path;

/**
 * This example demonstrates how to extract XMP metadata from a file.
 */
public class ReadXmpProperties {
    public static IXmp run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IXmp root = (IXmp) metadata.getRootPackage();
            if (root.getXmpPackage() != null) {
                if (root.getXmpPackage().getSchemes().getXmpBasic() != null) {
                    System.out.println("\tXMP Basic:");
                    System.out.println("\t\tCreator Tool: " + root.getXmpPackage().getSchemes().getXmpBasic().getCreatorTool());
                    System.out.println("\t\tCreate Date: " + root.getXmpPackage().getSchemes().getXmpBasic().getCreateDate());
                    System.out.println("\t\tModify Date: " + root.getXmpPackage().getSchemes().getXmpBasic().getModifyDate());
                    System.out.println("\t\tLabel: " + root.getXmpPackage().getSchemes().getXmpBasic().getLabel());
                    System.out.println("\t\tNickname: " + root.getXmpPackage().getSchemes().getXmpBasic().getNickname());
                    // ...
                }
                if (root.getXmpPackage().getSchemes().getDublinCore() != null) {
                    System.out.println("\tDublin Core:");
                    System.out.println("\t\tFormat: " + root.getXmpPackage().getSchemes().getDublinCore().getFormat());
                    System.out.println("\t\tCoverage: " + root.getXmpPackage().getSchemes().getDublinCore().getCoverage());
                    System.out.println("\t\tIdentifier: " + root.getXmpPackage().getSchemes().getDublinCore().getIdentifier());
                    System.out.println("\t\tSource: " + root.getXmpPackage().getSchemes().getDublinCore().getSource());
                    // ...
                }
                if (root.getXmpPackage().getSchemes().getPhotoshop() != null) {
                    System.out.println("\tPhotoshop:");
                    System.out.println("\t\tColor Mode: " + root.getXmpPackage().getSchemes().getPhotoshop().getColorMode());
                    System.out.println("\t\tICC Profile: " + root.getXmpPackage().getSchemes().getPhotoshop().getIccProfile());
                    System.out.println("\t\tCountry: " + root.getXmpPackage().getSchemes().getPhotoshop().getCountry());
                    System.out.println("\t\tCity: " + root.getXmpPackage().getSchemes().getPhotoshop().getCity());
                    System.out.println("\t\tDate Created: " + root.getXmpPackage().getSchemes().getPhotoshop().getDateCreated());
                }
                // ...
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
