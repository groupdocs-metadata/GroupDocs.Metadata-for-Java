// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.font;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;

/**
 * This example shows how to read OpenType font metadata.
 */
public class OpenTypeReadNativeMetadataProperties {
    public static OpenTypeRootPackage run(Path inputFile) {
        // Read the OpenType font metadata
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            OpenTypeRootPackage root = metadata.getRootPackageGeneric();
            for (OpenTypeFont metadataEntry : root.getOpenTypePackage().getFonts()) {
                // Display the values of some metadata properties
                System.out.printf("\tCreated: %s%n", metadataEntry.getCreated());
                System.out.printf("\tDirectionHint: %s%n", metadataEntry.getDirectionHint());
                System.out.printf("\tEmbeddingLicensingRights: %s%n", metadataEntry.getEmbeddingLicensingRights());
                System.out.printf("\tFlags: %s%n", metadataEntry.getFlags());
                System.out.printf("\tFontFamilyName: %s%n", metadataEntry.getFontFamilyName());
                System.out.printf("\tFontRevision: %s%n", metadataEntry.getFontRevision());
                System.out.printf("\tFontSubfamilyName: %s%n", metadataEntry.getFontSubfamilyName());
                System.out.printf("\tFullFontName: %s%n", metadataEntry.getFullFontName());
                System.out.printf("\tGlyphBounds: %s%n", metadataEntry.getGlyphBounds());
                System.out.printf("\tMajorVersion: %s%n", metadataEntry.getMajorVersion());
                System.out.printf("\tMinorVersion: %s%n", metadataEntry.getMinorVersion());
                System.out.printf("\tModified: %s%n", metadataEntry.getModified());
                System.out.printf("\tSfntVersion: %s%n", metadataEntry.getSfntVersion());
                System.out.printf("\tStyle: %s%n", metadataEntry.getStyle());
                System.out.printf("\tTypographicFamily: %s%n", metadataEntry.getTypographicFamily());
                System.out.printf("\tTypographicSubfamily: %s%n", metadataEntry.getTypographicSubfamily());
                System.out.printf("\tWeight: %s%n", metadataEntry.getWeight());
                System.out.printf("\tWidth: %s%n", metadataEntry.getWidth());
                for (OpenTypeBaseNameRecord nameRecord : metadataEntry.getNames()) {
                    System.out.printf("\t\tNameID: %s%n", nameRecord.getNameID());
                    System.out.printf("\t\tPlatform: %s%n", nameRecord.getPlatform());
                    System.out.printf("\t\tValue: %s%n", nameRecord.getValue());
                    if (nameRecord instanceof OpenTypeMacintoshNameRecord) {
                        OpenTypeMacintoshNameRecord macintoshNameRecord = (OpenTypeMacintoshNameRecord) nameRecord;
                        System.out.printf("\t\t\tEncoding: %s%n", macintoshNameRecord.getEncoding());
                        System.out.printf("\t\t\tLanguage: %s%n", macintoshNameRecord.getLanguage());
                    } else {
                        if (nameRecord instanceof OpenTypeUnicodeNameRecord) {
                            OpenTypeUnicodeNameRecord unicodeNameRecord = (OpenTypeUnicodeNameRecord) nameRecord;
                            System.out.printf("\t\t\tEncoding: %s%n", unicodeNameRecord.getEncoding());
                        } else {
                            if (nameRecord instanceof OpenTypeWindowsNameRecord) {
                                OpenTypeWindowsNameRecord windowsNameRecord = (OpenTypeWindowsNameRecord) nameRecord;
                                System.out.printf("\t\t\tEncoding: %s%n", windowsNameRecord.getEncoding());
                                System.out.printf("\t\t\tLanguage: %s%n", windowsNameRecord.getLanguage());
                            }
                        }
                    }
                }
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
