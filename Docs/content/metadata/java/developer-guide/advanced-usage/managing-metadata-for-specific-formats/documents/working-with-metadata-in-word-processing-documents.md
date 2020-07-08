---
id: working-with-metadata-in-word-processing-documents
url: metadata/java/working-with-metadata-in-word-processing-documents
title: Working with metadata in Word Processing documents
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata for Java provides functionality that allows working with different kinds of WordProcessing documents such as DOC, DOCX, ODT, etc. For the full list of supported document formats please refer to [Supported document formats]({{< ref "metadata/java/getting-started/supported-document-formats.md" >}}).

## Detecting the exact type of a document

The following sample of code will help you to detect the exact type of a loaded document and extract some additional file format information.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a WordProcessing document
2.  Extract the root metadata package
3.  Use the [getWordProcessingType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/WordProcessingRootPackage#getWordProcessingType()) method to obtain file format information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingReadFileFormatProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();
	System.out.println(root.getWordProcessingType().getFileFormat());
	System.out.println(root.getWordProcessingType().getWordProcessingFormat());
	System.out.println(root.getWordProcessingType().getMimeType());
	System.out.println(root.getWordProcessingType().getExtension());
}
```

## Reading built-in metadata properties

To access built-in metadata of a WordProcessing document, please use the [getDocumentProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage#getDocumentProperties()) method defined in the [DocumentRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage) class.

The following code snippet extracts built-in metadata properties and displays them on the screen.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingReadBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDocx)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();
	System.out.println(root.getDocumentProperties().getAuthor());
	System.out.println(root.getDocumentProperties().getCreatedTime());
	System.out.println(root.getDocumentProperties().getCompany());
	System.out.println(root.getDocumentProperties().getCategory());
	System.out.println(root.getDocumentProperties().getKeywords());

	// ...
}
```

## Reading custom metadata properties

If you need to extract custom metadata properties of a WordProcessing document please follow the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingReadCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();

	IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());

	for (MetadataProperty property : customProperties) {
		System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
	}
}
```

As you can see the code sample uses the GroupDocs.Metadata search engine to retrieve all properties that are not marked with the BuiltIn tag. Since we call the [findProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataPackage#findProperties(com.groupdocs.metadata.search.Specification)) method for a certain metadata package (instance of the [WordProcessingPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/WordProcessingPackage) class), the search result will contain only metadata properties that are specific for WordProcessing documents. 

## Inspecting WordProcessing documents

The inspection feature that is introduced in this section doesn't work with metadata directly but extracts some useful pieces of information that can be considered as metadata under some circumstances. For example, you may want to obtain information about digital signatures associated with a document, extract user comments from the document content, obtain pieces of hidden text, work with document revisions, etc. Please follow the example below to learn how to do that.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a WordProcessing document
2.  Extract the root metadata package
3.  Use the [getInspectionPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/WordProcessingRootPackage#getInspectionPackage()) method to inspect the document

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingReadInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDocx)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();
	if (root.getInspectionPackage().getComments() != null) {
		for (WordProcessingComment comment : root.getInspectionPackage().getComments()) {
			System.out.println(comment.getAuthor());
			System.out.println(comment.getCreatedDate());
			System.out.println(comment.getText());

			// ...
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
		for (WordProcessingField field : root.getInspectionPackage().getFields()) {
			System.out.println(field.getCode());
			System.out.println(field.getResult());
		}
	}

	if (root.getInspectionPackage().getHiddenText() != null) {
		for (String textFragment : root.getInspectionPackage().getHiddenText()) {
			System.out.println(textFragment);
		}
	}

	if (root.getInspectionPackage().getRevisions() != null) {
		for (WordProcessingRevision revision : root.getInspectionPackage().getRevisions()) {
			System.out.println(revision.getAuthor());
			System.out.println(revision.getDateTime());
			System.out.println(revision.getRevisionType());
		}
	}
}
```

## Reading document statistics

Most office applications are able to display simple text statistics for loaded documents. It can be an estimated word count, page count, character count, etc. The GroupDocs.Metadata API provides similar functionality for some document formats. The following code sample demonstrates how to obtain the text statistics for a WordProcessing document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingReadDocumentStatistics**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDocx)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentStatistics().getCharacterCount());
	System.out.println(root.getDocumentStatistics().getPageCount());
	System.out.println(root.getDocumentStatistics().getWordCount());
}
```

## Reading Dublin Core metadata

Dublin Core metadata is a set of certain metadata properties that are intended to describe various digital resources. Please find more information on the Dublin Core standard at [https://en.wikipedia.org/wiki/Dublin\_Core](https://en.wikipedia.org/wiki/Dublin_Core). The code sample below shows how to extract Dublin Core metadata from a WordProcessing document using the GroupDocs.Metadata API.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingReadDublinCoreProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDocx)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();

	if (root.getDublinCorePackage() != null) {
		System.out.println(root.getDublinCorePackage().getFormat());
		System.out.println(root.getDublinCorePackage().getContributor());
		System.out.println(root.getDublinCorePackage().getCoverage());
		System.out.println(root.getDublinCorePackage().getCreator());
		System.out.println(root.getDublinCorePackage().getSource());
		System.out.println(root.getDublinCorePackage().getDescription());

		// ...
	}
}
```

Please see the [DublinCorePackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DublinCorePackage) class to get more information on supported Dublin Core metadata properties.

## Updating built-In metadata properties

Updating any built-in document properties is as simple as getting them. The following code sample demonstrates how to update built-in metadata properties in a WordProcessing document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingUpdateBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {

	WordProcessingRootPackage root = metadata.getRootPackageGeneric();
	root.getDocumentProperties().setAuthor("test author");
	root.getDocumentProperties().setCreatedTime(new Date());
	root.getDocumentProperties().setCompany("GroupDocs");
	root.getDocumentProperties().setCategory("test category");
	root.getDocumentProperties().setKeywords("metadata, built-in, update");

	// ...

	metadata.save(Constants.OutputDoc);
}
```

## Adding or updating custom metadata properties

The GroupDocs.Metadata API also allows adding and updating custom metadata properties in a WordProcessing document. Please check the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingUpdateCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDocx)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().set("customProperty1", "some value");
	root.getDocumentProperties().set("customProperty2", 7);

	metadata.save(Constants.OutputDocx);
}
```

## Updating inspection properties

When you inspect a document GroupDocs.Metadata for Java forms a metadata package containing the extracted information. The package class also provides some basic methods that allow updating (or removing) the extracted properties. The following code sample demonstrates how to remove/update the inspection properties in a WordProcessing document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingUpdateInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();
	root.getInspectionPackage().clearComments();
	root.getInspectionPackage().acceptAllRevisions();
	root.getInspectionPackage().clearFields();
	root.getInspectionPackage().clearHiddenText();
	metadata.save(Constants.OutputDoc);
}
```

## Updating document statistics

The document statistics described in [this section]({{< ref "metadata/java/developer-guide/advanced-usage/managing-metadata-for-specific-formats/documents/working-with-metadata-in-word-processing-documents.md" >}}) are not only calculated for WordProcessing documents, they can also be saved in the native metadata package with regular metadata properties. The following code sample demonstrates how to achieve this.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.word\_processing.<WBR>WordProcessingUpdateDocumentStatistics**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();

	root.updateDocumentStatistics();

	metadata.save(Constants.OutputDoc);
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
