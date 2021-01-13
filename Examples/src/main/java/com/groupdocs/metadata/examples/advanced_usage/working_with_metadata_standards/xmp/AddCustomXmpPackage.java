// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This example demonstrates how to add a custom XMP package to a file of any supported format.
 */
public class AddCustomXmpPackage {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputJpeg)) {
            IXmp root = (IXmp) metadata.getRootPackage();
            XmpPacketWrapper packet = new XmpPacketWrapper();

            XmpPackage custom = new XmpPackage("gd", "https://groupdocs.com");
            custom.set("gd:Copyright", "Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.");
            custom.set("gd:CreationDate", new Date());
            custom.set("gd:Company", XmpArray.from(new String[]{"Aspose", "GroupDocs"}, XmpArrayType.Ordered));

            packet.addPackage(custom);
            root.setXmpPackage(packet);

            metadata.save(Constants.OutputJpeg);
        }
    }
}
