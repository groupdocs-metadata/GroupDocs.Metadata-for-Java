---
id: load-a-password-protected-document
url: metadata/java/load-a-password-protected-document
title: Load a password-protected document
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
This example demonstrates how to load a password-protected document.

**advanced\_usage.loading\_files.LoadPasswordProtectedDocument**

```csharp
// Specify the password
LoadOptions loadOptions = new LoadOptions();
loadOptions.setPassword("123");

// Constants.ProtectedDocx is an absolute or relative path to your document. Ex: @"C:\Docs\source.docx"
try (Metadata metadata = new Metadata(Constants.ProtectedDocx, loadOptions)) {
	// Extract, edit or remove metadata here
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
