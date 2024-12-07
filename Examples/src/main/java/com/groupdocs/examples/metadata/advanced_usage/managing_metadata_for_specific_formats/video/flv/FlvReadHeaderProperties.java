// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.flv;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FlvRootPackage;

import java.nio.file.Path;

/**
 * This example shows how to read FLV header properties.
 */
public class FlvReadHeaderProperties {
    public static FlvRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            FlvRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tVersion: %s%n", root.getHeader().getVersion());
            System.out.printf("\tHas Audio Tags: %s%n", root.getHeader().hasAudioTags());
            System.out.printf("\tHas Video Tags: %s%n", root.getHeader().hasVideoTags());
            System.out.printf("\tType Flags: %s%n", root.getHeader().getTypeFlags());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
