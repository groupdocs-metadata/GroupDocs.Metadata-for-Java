// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.font;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to read OpenType font metadata.
 */
public class OpenTypeReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputTtf)) {
            OpenTypeRootPackage root = metadata.getRootPackageGeneric();

            // Read the OpenType font metadata
            for (OpenTypeFont metadataEntry : root.getOpenTypePackage().getFonts()) {
                // Display the values of some metadata properties
                System.out.println(metadataEntry.getCreated());
                System.out.println(metadataEntry.getDirectionHint());
                System.out.println(metadataEntry.getEmbeddingLicensingRights());
                System.out.println(metadataEntry.getFlags());
                System.out.println(metadataEntry.getFontFamilyName());
                System.out.println(metadataEntry.getFontRevision());
                System.out.println(metadataEntry.getFontSubfamilyName());
                System.out.println(metadataEntry.getFullFontName());
                System.out.println(metadataEntry.getGlyphBounds());
                System.out.println(metadataEntry.getMajorVersion());
                System.out.println(metadataEntry.getMinorVersion());
                System.out.println(metadataEntry.getModified());
                System.out.println(metadataEntry.getSfntVersion());
                System.out.println(metadataEntry.getStyle());
                System.out.println(metadataEntry.getTypographicFamily());
                System.out.println(metadataEntry.getTypographicSubfamily());
                System.out.println(metadataEntry.getWeight());
                System.out.println(metadataEntry.getWidth());
                for (OpenTypeBaseNameRecord nameRecord : metadataEntry.getNames()) {
                    System.out.println(nameRecord.getNameID());
                    System.out.println(nameRecord.getPlatform());
                    System.out.println(nameRecord.getValue());

                    if (nameRecord instanceof OpenTypeMacintoshNameRecord) {
                        OpenTypeMacintoshNameRecord macintoshNameRecord = (OpenTypeMacintoshNameRecord) nameRecord;
                        System.out.println(macintoshNameRecord.getEncoding());
                        System.out.println(macintoshNameRecord.getLanguage());
                    } else {
                        if (nameRecord instanceof OpenTypeUnicodeNameRecord) {
                            OpenTypeUnicodeNameRecord unicodeNameRecord = (OpenTypeUnicodeNameRecord) nameRecord;
                            System.out.println(unicodeNameRecord.getEncoding());
                        } else {
                            if (nameRecord instanceof OpenTypeWindowsNameRecord) {
                                OpenTypeWindowsNameRecord windowsNameRecord = (OpenTypeWindowsNameRecord) nameRecord;
                                System.out.println(windowsNameRecord.getEncoding());
                                System.out.println(windowsNameRecord.getLanguage());
                            }
                        }
                    }
                }
            }
        }
    }
}
