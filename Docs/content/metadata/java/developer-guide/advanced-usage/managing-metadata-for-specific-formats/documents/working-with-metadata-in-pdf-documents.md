---
id: working-with-metadata-in-pdf-documents
url: metadata/java/working-with-metadata-in-pdf-documents
title: Working with metadata in PDF documents
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Detecting the version of a PDF document

The following sample of code will help you to detect the PDF version a loaded document and extract some additional file format information.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a PDF document
2.  Extract the root metadata package
3.  Use the [getPdfType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PdfRootPackage#getPdfType()) method to obtain file format information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfReadFileFormatProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getPdfType().getFileFormat());
	System.out.println(root.getPdfType().getVersion());
	System.out.println(root.getPdfType().getMimeType());
	System.out.println(root.getPdfType().getExtension());
}
```

## Reading built-in metadata properties

To access built-in metadata of a PDF document, please use the [getDocumentProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage#getDocumentProperties()) method defined in the [DocumentRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage) class.

The following code snippet extracts built-in metadata properties and displays them on the screen.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfReadBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentProperties().getAuthor());
	System.out.println(root.getDocumentProperties().getCreatedDate());
	System.out.println(root.getDocumentProperties().getSubject());
	System.out.println(root.getDocumentProperties().getProducer());
	System.out.println(root.getDocumentProperties().getKeywords());

	// ...
}
```

## Reading custom metadata properties

If you need to extract custom metadata properties of a PDF document please follow the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfReadCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();

	IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());

	for (MetadataProperty property : customProperties) {
		System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
	}
}
```

As you can see the code sample uses the GroupDocs.Metadata search engine to retrieve all properties that are not marked with the BuiltIn tag. Since we call the [findProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataPackage#findProperties(com.groupdocs.metadata.search.Specification)) method for a certain metadata package (instance of the [PdfPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PdfPackage) class), the search result will contain only metadata properties that are specific for PDF documents. 

## Inspecting PDF documents

The inspection feature that is introduced in this section doesn't work with metadata directly but extracts some useful pieces of information that can be considered as metadata under some circumstances. For example, you may want to obtain information about digital signatures associated with a document, extract form fields, attachments, bookmarks, etc. Please follow the example below to learn how to do that.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a PDF document
2.  Extract the root metadata package
3.  Use the [getInspectionPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PdfRootPackage#getInspectionPackage()) method to inspect the document

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfReadInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.SignedPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();

	if (root.getInspectionPackage().getAnnotations() != null) {
		for (PdfAnnotation annotation : root.getInspectionPackage().getAnnotations()) {
			System.out.println(annotation.getName());
			System.out.println(annotation.getText());
			System.out.println(annotation.getPageNumber());
		}
	}

	if (root.getInspectionPackage().getAttachments() != null) {
		for (PdfAttachment attachment : root.getInspectionPackage().getAttachments()) {
			System.out.println(attachment.getName());
			System.out.println(attachment.getMimeType());
			System.out.println(attachment.getDescription());
		}
	}

	if (root.getInspectionPackage().getBookmarks() != null) {
		for (PdfBookmark bookmark : root.getInspectionPackage().getBookmarks()) {
			System.out.println(bookmark.getTitle());
		}
	}

	if (root.getInspectionPackage().getDigitalSignatures() != null) {
		for (DigitalSignature signature : root.getInspectionPackage().getDigitalSignatures()) {
			System.out.println(signature.getCertificateSubject());
			System.out.println(signature.getComments());
			System.out.println(signature.getSignTime());
			// ...
		}
	}

	if (root.getInspectionPackage().getFields() != null) {
		for (PdfFormField field : root.getInspectionPackage().getFields()) {
			System.out.println(field.getName());
			System.out.println(field.getValue());
			// ...
		}
	}
}
```

## Reading document statistics

Most office applications are able to display simple text statistics for loaded documents. It can be an estimated word count, page count, character count, etc. The GroupDocs.Metadata API provides similar functionality for some document formats. The following code sample demonstrates how to obtain the text statistics for a PDF document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfReadDocumentStatistics**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentStatistics().getCharacterCount());
	System.out.println(root.getDocumentStatistics().getPageCount());
	System.out.println(root.getDocumentStatistics().getWordCount());
}
```

## Updating built-In metadata properties

Updating any built-in document properties is as simple as getting them. The following code sample demonstrates how to update built-in metadata properties in a PDF document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfUpdateBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();
	root.getDocumentProperties().setAuthor("test author");
	root.getDocumentProperties().setCreatedDate(new Date());
	root.getDocumentProperties().setTitle("test title");
	root.getDocumentProperties().setKeywords("metadata, built-in, update");

	// ...

	metadata.save(Constants.OutputPdf);
}
```

## Adding or updating custom metadata properties

The GroupDocs.Metadata API also allows adding and updating custom metadata properties in a PDF document. Please check the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfUpdateCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().set("customProperty1", "some value");

	metadata.save(Constants.OutputPdf);
}
```

## Updating inspection properties

When you inspect a document GroupDocs.Metadata for Java forms a metadata package containing the extracted information. The package class also provides some basic methods that allow removing the extracted properties. The following code sample demonstrates how to remove the inspection properties from a PDF document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.pdf.<WBR>PdfUpdateInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.SignedPdf)) {
	PdfRootPackage root = metadata.getRootPackageGeneric();

	root.getInspectionPackage().clearAnnotations();
	root.getInspectionPackage().clearAttachments();
	root.getInspectionPackage().clearFields();
	root.getInspectionPackage().clearBookmarks();
	root.getInspectionPackage().clearDigitalSignatures();

	metadata.save(Constants.OutputPdf);
}
```

## Working with XMP metadata

GroupDocs.Metadata for Java also allows managing XMP metadata in PDF files. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}})

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
