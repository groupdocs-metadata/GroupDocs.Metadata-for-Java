// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IXmp;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to extract XMP metadata from a file.
 */
public class ReadXmpProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.PngWithXmp)) {
            IXmp root = (IXmp) metadata.getRootPackage();
            if (root.getXmpPackage() != null) {
                if (root.getXmpPackage().getSchemes().getXmpBasic() != null) {
                    System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getCreatorTool());
                    System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getCreateDate());
                    System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getModifyDate());
                    System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getLabel());
                    System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getNickname());

                    // ...
                }

                if (root.getXmpPackage().getSchemes().getDublinCore() != null) {
                    System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getFormat());
                    System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getCoverage());
                    System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getIdentifier());
                    System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getSource());

                    // ...
                }

                if (root.getXmpPackage().getSchemes().getPhotoshop() != null) {
                    System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getColorMode());
                    System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getIccProfile());
                    System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getCountry());
                    System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getCity());
                    System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getDateCreated());

                    // ...
                }

                // ...
            }
        }
    }
}
