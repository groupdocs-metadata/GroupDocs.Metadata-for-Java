---
id: exporting-metadata-properties
url: metadata/java/exporting-metadata-properties
title: Exporting metadata properties
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
This example demonstrates how to export metadata properties to an Excel workbook. For more information please refer to the [ExportManager](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.export/ExportManager) class.

**advanced\_usage.ExportingMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {
	RootMetadataPackage root = metadata.getRootPackage();
	if (root != null) {
		// Initialize the export manager with the root metadata package to export the whole metadata tree
		ExportManager manager = new ExportManager(root);
		manager.export(Constants.OutputXls, ExportFormat.Xls);
	}
} 
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured .NET library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
