// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.video.flv;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FlvRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to read FLV header properties.
 */
public class FlvReadHeaderProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputFlv)) {
            FlvRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getHeader().getVersion());
            System.out.println(root.getHeader().hasAudioTags());
            System.out.println(root.getHeader().hasVideoTags());
            System.out.println(root.getHeader().getTypeFlags());
        }
    }
}
