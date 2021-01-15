---
id: working-with-metadata-in-note-formats
url: metadata/java/working-with-metadata-in-note-formats
title: Working with metadata in Note formats
weight: 7
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata for Java provides functionality that allows working with ONE files created by different versions of Microsoft OneNote. Please see the code samples below for more information.

## Inspecting Note documents

The inspection feature that is introduced in this section doesn't work with metadata directly but extracts some useful pieces of information that can be considered as metadata under some circumstances. For example, you may want to obtain information about pages in a note document. Please follow the example below to learn how to do that.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a Note document
2.  Extract the root metadata package
3.  Use the [getInspectionPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/NoteRootPackage#getInspectionPackage()) method to inspect the document

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.note.<WBR>NoteReadInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputOne)) {
	NoteRootPackage root = metadata.getRootPackageGeneric();
	if (root.getInspectionPackage().getPages() != null) {
		for (NotePage page : root.getInspectionPackage().getPages()) {
			System.out.println(page.getTitle());
			System.out.println(page.getAuthor());
			System.out.println(page.getCreationTime());
			System.out.println(page.getLastModificationTime());
		}
	}
}
```

## Reading document statistics

Most office applications are able to display simple text statistics for loaded documents. It can be an estimated word count, page count, character count, etc. The GroupDocs.Metadata API provides similar functionality for some document formats. The following code sample demonstrates how to obtain the text statistics for a Note document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.note.<WBR>NoteReadDocumentStatistics**

```csharp
try (Metadata metadata = new Metadata(Constants.InputOne)) {
    NoteRootPackage root = metadata.getRootPackageGeneric();
    System.out.println(root.getDocumentStatistics().getCharacterCount());
    System.out.println(root.getDocumentStatistics().getPageCount());
    System.out.println(root.getDocumentStatistics().getWordCount());
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
