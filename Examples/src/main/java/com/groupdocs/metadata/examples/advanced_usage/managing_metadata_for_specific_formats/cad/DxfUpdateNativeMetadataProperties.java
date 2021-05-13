// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.cad;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.CadRootPackage;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.WithNameSpecification;
import java.util.Date;

/**
 * This code sample shows how to update metadata of a DXF drawing.
 */
public class DxfUpdateNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDxf)) {
            CadRootPackage root = metadata.getRootPackageGeneric();

            root.getCadPackage().setProperties(new WithNameSpecification("Author"), new PropertyValue("GroupDocs"));
            root.getCadPackage().setProperties(new WithNameSpecification("Comments"), new PropertyValue("test comment"));
            root.getCadPackage().setProperties(new WithNameSpecification("HyperlinkBase"), new PropertyValue("test hyperlink base"));
            root.getCadPackage().setProperties(new WithNameSpecification("Keywords"), new PropertyValue("test keywords"));
            root.getCadPackage().setProperties(new WithNameSpecification("LastSavedBy"), new PropertyValue("test editor"));
            root.getCadPackage().setProperties(new WithNameSpecification("RevisionNumber"), new PropertyValue("test revision number"));
            root.getCadPackage().setProperties(new WithNameSpecification("Subject"), new PropertyValue("test subject"));
            root.getCadPackage().setProperties(new WithNameSpecification("Title"), new PropertyValue("test title"));
            root.getCadPackage().setProperties(new WithNameSpecification("CreatedDateTime"), new PropertyValue(new Date()));
            root.getCadPackage().setProperties(new WithNameSpecification("ModifiedDateTime"), new PropertyValue(new Date()));

            metadata.save(Constants.OutputDxf);
        }
    }
}
