// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.SpreadsheetContentTypeProperty;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.Path;

/**
 * This code snippet demonstrates how to extract custom metadata properties from a spreadsheet.
 */
public class SpreadsheetReadCustomProperties {
    public static SpreadsheetRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
            IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());
            for (MetadataProperty property : customProperties) {
                System.out.printf("\t%s = %s%n", property.getName(), property.getValue());
            }

            for (SpreadsheetContentTypeProperty contentTypeProperty : root.getDocumentProperties().getContentTypeProperties().toList()) {
                System.out.printf("\t\t%s, %s = %s%n", contentTypeProperty.getSpreadsheetPropertyType(), contentTypeProperty.getName(), contentTypeProperty.getSpreadsheetPropertyValue());
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
