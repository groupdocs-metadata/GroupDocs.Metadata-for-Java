---
id: save-a-modified-file-to-the-original-source
url: metadata/java/save-a-modified-file-to-the-original-source
title: Save a modified file to the original source
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
This example shows how to save the modified content to the underlying file.

**advanced\_usage.saving\_files.SaveFileToOriginalSource**

```csharp
// Constants.InputPpt is an absolute or relative path to your document. Ex: @"C:\Docs\test.ppt"
File outputFile = new File(Constants.OutputPpt);
outputFile.delete();
Files.copy(new File(Constants.InputPpt).toPath(), outputFile.toPath());

try (Metadata metadata = new Metadata(Constants.OutputPpt)) {
	// Edit or remove metadata here
	// Saves the document to the underlying file
	metadata.save();
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
