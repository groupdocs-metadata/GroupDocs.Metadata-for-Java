// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.png;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IXmp;
import com.groupdocs.metadata.core.XmpBasicPackage;
import com.groupdocs.metadata.core.XmpDublinCorePackage;
import com.groupdocs.metadata.core.XmpPacketWrapper;
import com.groupdocs.metadata.examples.Constants;
import java.util.Date;

/**
 * This code sample shows how to update XMP metadata properties in a PNG image.
 */
public class PngUpdateXmpProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # PngUpdateXmpProperties : How to update XMP metadata properties in a PNG image.\n");
        try (Metadata metadata = new Metadata(Constants.PngWithXmp)) {
            IXmp root = (IXmp) metadata.getRootPackage();
            if (root.getXmpPackage() == null) {
                root.setXmpPackage(new XmpPacketWrapper());
            }

            if (root.getXmpPackage().getSchemes().getDublinCore() == null) {
                root.getXmpPackage().getSchemes().setDublinCore(new XmpDublinCorePackage());
            }
            root.getXmpPackage().getSchemes().getDublinCore().setFormat("image/png");
            root.getXmpPackage().getSchemes().getDublinCore().setRights("Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.");
            root.getXmpPackage().getSchemes().getDublinCore().setSubject("test");

            if (root.getXmpPackage().getSchemes().getXmpBasic() == null) {
                root.getXmpPackage().getSchemes().setXmpBasic(new XmpBasicPackage());
            }
            root.getXmpPackage().getSchemes().getXmpBasic().setCreateDate(new Date());
            root.getXmpPackage().getSchemes().getXmpBasic().setLabel("GroupDocs");
            root.getXmpPackage().getSchemes().getXmpBasic().setRating(5);
            root.getXmpPackage().getSchemes().getXmpBasic().setCreatorTool("GroupDocs.Metadata");

            // ...

            metadata.save(Constants.OutputPng);
        }
    }
}
