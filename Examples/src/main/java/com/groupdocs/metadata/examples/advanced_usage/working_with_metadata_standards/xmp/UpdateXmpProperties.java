// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This example shows how to update XMP metadata properties.
 */
public class UpdateXmpProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.GifWithXmp)) {
            IXmp root = (IXmp) metadata.getRootPackage();
            if (root.getXmpPackage() != null) {
                // if there is no such scheme in the XMP package we should create it
                if (root.getXmpPackage().getSchemes().getDublinCore() == null) {
                    root.getXmpPackage().getSchemes().setDublinCore(new XmpDublinCorePackage());
                }
                root.getXmpPackage().getSchemes().getDublinCore().setFormat("image/gif");
                root.getXmpPackage().getSchemes().getDublinCore().setRights("Copyright (C) 2011-2021 GroupDocs. All Rights Reserved");
                root.getXmpPackage().getSchemes().getDublinCore().setSubject("test");

                if (root.getXmpPackage().getSchemes().getCameraRaw() == null) {
                    root.getXmpPackage().getSchemes().setCameraRaw(new XmpCameraRawPackage());
                }
                root.getXmpPackage().getSchemes().getCameraRaw().setShadows(50);
                root.getXmpPackage().getSchemes().getCameraRaw().setAutoBrightness(true);
                root.getXmpPackage().getSchemes().getCameraRaw().setAutoExposure(true);
                root.getXmpPackage().getSchemes().getCameraRaw().setCameraProfile("test");
                root.getXmpPackage().getSchemes().getCameraRaw().setExposure(0.0001);

                // If you don't want to keep the old values just replace the whole scheme
                root.getXmpPackage().getSchemes().setXmpBasic(new XmpBasicPackage());
                root.getXmpPackage().getSchemes().getXmpBasic().setCreateDate(new Date());
                root.getXmpPackage().getSchemes().getXmpBasic().setBaseUrl("https://groupdocs.com");
                root.getXmpPackage().getSchemes().getXmpBasic().setRating(5);

                root.getXmpPackage().getSchemes().setBasicJobTicket(new XmpBasicJobTicketPackage());

                // Set a complex type property
                XmpJob job = new XmpJob();
                job.setID("1");
                job.setName("test job");
                job.setUrl("https://groupdocs.com");

                root.getXmpPackage().getSchemes().getBasicJobTicket().setJobs(new XmpJob[]{job});

                // ...

                metadata.save(Constants.OutputGif);
            }
        }
    }
}
