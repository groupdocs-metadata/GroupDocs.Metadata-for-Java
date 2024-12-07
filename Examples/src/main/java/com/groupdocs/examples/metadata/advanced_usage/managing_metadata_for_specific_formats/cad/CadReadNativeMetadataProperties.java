// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.cad;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.CadRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to read metadata of a CAD drawing.
 */
public class CadReadNativeMetadataProperties {
    public static CadRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            CadRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tAcad Version: %s%n", root.getCadPackage().getAcadVersion());
            System.out.printf("\tAuthor: %s%n", root.getCadPackage().getAuthor());
            System.out.printf("\tComments: %s%n", root.getCadPackage().getComments());
            System.out.printf("\tCreated DateTime: %s%n", root.getCadPackage().getCreatedDateTime());
            System.out.printf("\tHyperlink Base: %s%n", root.getCadPackage().getHyperlinkBase());
            System.out.printf("\tKeywords: %s%n", root.getCadPackage().getKeywords());
            System.out.printf("\tLast Saved By: %s%n", root.getCadPackage().getLastSavedBy());
            System.out.printf("\tTitle: %s%n", root.getCadPackage().getTitle());
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
