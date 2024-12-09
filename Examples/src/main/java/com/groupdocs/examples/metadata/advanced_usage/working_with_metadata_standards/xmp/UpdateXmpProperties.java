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
 * This example shows how to update XMP metadata properties.
 */
public class UpdateXmpProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("UpdateXmpProperties.gif");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
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

                metadata.save(outputPath.toString());

                System.out.println("..sample finished successfully.\n");
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
