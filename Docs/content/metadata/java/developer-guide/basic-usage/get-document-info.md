---
id: get-document-info
url: metadata/java/get-document-info
title: Get document info
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata allows users to get document information which includes:

*   [File format](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/FileTypePackage#getFileFormat()) (detected by the internal structure)
*   [File extension](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/FileTypePackage#getExtension())
*   [MIME type](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/FileTypePackage#getMimeType())
*   [Number of pages](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IDocumentInfo#getPageCount())
*   [File size](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IDocumentInfo#getSize())
*   A [value](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IDocumentInfo#isEncrypted()) indicating whether a file is encrypted

The following code sample demonstrates how to extract basic format information from a file.

**basic\_usage.GetDocumentInfo**

```csharp
// Constants.InputXlsx is an absolute or relative path to your document. Ex: @"C:\Docs\source.xlsx"
try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
	if (metadata.getFileFormat() != FileFormat.Unknown) {
		IDocumentInfo info = metadata.getDocumentInfo();
		System.out.println(String.format("File format: %s", info.getFileType().getFileFormat()));
		System.out.println(String.format("File extension: %s", info.getFileType().getExtension()));
		System.out.println(String.format("MIME Type: %s", info.getFileType().getMimeType()));
		System.out.println(String.format("Number of pages: %s", info.getPageCount()));
		System.out.println(String.format("Document size: %s bytes", info.getSize()));
		System.out.println(String.format("Is document encrypted: %s", info.isEncrypted()));
	}
}
```

## More resources

### Advanced usage topics

To learn more about library features and get familiar how to manage metadata and more, please refer to the[advanced usage section]({{< ref "metadata/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with a full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
