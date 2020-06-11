---
id: load-a-file-of-a-specific-format
url: metadata/java/load-a-file-of-a-specific-format
title: Load a file of a specific format
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
This example demonstrates how to load a file of some particular format.

**advanced\_usage.loading\_files.LoadingFileOfSpecificFormat**

```csharp
// Explicitly specifying the format of a file to load you can spare some time on detecting the format
LoadOptions loadOptions = new LoadOptions(FileFormat.Spreadsheet);
// Constants.InputXls is an absolute or relative path to your document. Ex: @"C:\Docs\source.xls"
try (Metadata metadata = new Metadata(Constants.InputXls, loadOptions)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
	// Use format-specific properties to extract or edit metadata
	System.out.println(root.getDocumentProperties().getAuthor());
	// ...
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with a full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
