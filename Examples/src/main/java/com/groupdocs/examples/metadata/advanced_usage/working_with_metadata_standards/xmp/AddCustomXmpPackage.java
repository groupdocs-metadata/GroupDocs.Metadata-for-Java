// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to add a custom XMP package to a file of any supported format.
 */
public class AddCustomXmpPackage {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("AddCustomXmpPackage.jpg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IXmp root = (IXmp) metadata.getRootPackage();
            XmpPacketWrapper packet = new XmpPacketWrapper();
            XmpPackage custom = new XmpPackage("gd", "https://groupdocs.com");
            custom.set("gd:Copyright", "Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.");
            custom.set("gd:CreationDate", new Date());
            custom.set("gd:Company", XmpArray.from(new String[]{"Aspose", "GroupDocs"}, XmpArrayType.Ordered));
            packet.addPackage(custom);
            root.setXmpPackage(packet);

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
