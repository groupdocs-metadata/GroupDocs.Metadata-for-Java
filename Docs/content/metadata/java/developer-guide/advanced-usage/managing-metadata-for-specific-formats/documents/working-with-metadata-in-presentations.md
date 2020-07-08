---
id: working-with-metadata-in-presentations
url: metadata/java/working-with-metadata-in-presentations
title: Working with metadata in Presentations
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata for Java provides functionality that allows working with different kinds of presentations such as PPT, PPTX, POTM, POTX, etc. For the full list of supported presentation formats please refer to [Supported document formats]({{< ref "metadata/java/getting-started/supported-document-formats.md" >}}).

## Detecting the exact type of a presentation

The following sample of code will help you to detect the exact type of a loaded presentation and extract some additional file format information.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a presentation
2.  Extract the root metadata package
3.  Use the [getPresentationType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PresentationRootPackage#getPresentationType()) method to obtain file format information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationReadFileFormatProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPptx)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();
	System.out.println(root.getPresentationType().getFileFormat());
	System.out.println(root.getPresentationType().getPresentationFormat());
	System.out.println(root.getPresentationType().getMimeType());
	System.out.println(root.getPresentationType().getExtension());
}
```

## Reading built-In metadata properties

To access built-in metadata of a presentation, please use the [getDocumentProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage#getDocumentProperties()) method defined in the [DocumentRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage) class.

The following code snippet extracts built-in metadata properties and displays them on the screen.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationReadBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPpt)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentProperties().getAuthor());
	System.out.println(root.getDocumentProperties().getCreatedTime());
	System.out.println(root.getDocumentProperties().getCompany());
	System.out.println(root.getDocumentProperties().getCategory());
	System.out.println(root.getDocumentProperties().getKeywords());
	System.out.println(root.getDocumentProperties().getLastPrintedDate());
	System.out.println(root.getDocumentProperties().getNameOfApplication());

	// ...
}
```

## Reading custom metadata properties

If you need to extract custom metadata properties of a presentation please follow the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationReadCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPptx)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();

	IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());
	for (MetadataProperty property : customProperties) {
		System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
	}
}
```

As you can see the code sample uses the GroupDocs.Metadata search engine to retrieve all properties that are not marked with the BuiltIn tag. Since we call the [findProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataPackage#findProperties(com.groupdocs.metadata.search.Specification)) method for a certain metadata package (instance of the [PresentationPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PresentationPackage) class), the search result will contain only metadata properties that are specific for presentations. 

## Inspecting presentations

The inspection feature that is introduced in this section doesn't work with metadata directly but extracts some useful pieces of information that can be considered as metadata under some circumstances. For example, you may want to obtain information about hidden slides presented in a document or extract user comments from the document content. Please follow the example below to learn how to do that.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a Presentation document
2.  Extract the root metadata package
3.  Use the [getInspectionPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PresentationRootPackage#getInspectionPackage()) method to inspect the document

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationReadInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPpt)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();

	if (root.getInspectionPackage().getComments() != null) {
		for (PresentationComment comment : root.getInspectionPackage().getComments()) {
			System.out.println(comment.getAuthor());
			System.out.println(comment.getText());
			System.out.println(comment.getCreatedTime());
			System.out.println(comment.getSlideNumber());
		}
	}

	if (root.getInspectionPackage().getHiddenSlides() != null) {
		for (PresentationSlide slide : root.getInspectionPackage().getHiddenSlides()) {
			System.out.println(slide.getName());
			System.out.println(slide.getNumber());
			System.out.println(slide.getSlideId());
		}
	}
}
```

## Reading document statistics

Most office applications are able to display simple text statistics for loaded documents. It can be an estimated word count, page count, character count, etc. The GroupDocs.Metadata API provides similar functionality for some document formats. The following code sample demonstrates how to obtain the text statistics for a presentation.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationReadDocumentStatistics**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPpt)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentStatistics().getCharacterCount());
	System.out.println(root.getDocumentStatistics().getPageCount());
	System.out.println(root.getDocumentStatistics().getWordCount());
}
```

## Updating built-in metadata properties

Updating any built-in document properties is as simple as getting them. The following code sample demonstrates how to update built-in metadata properties in a presentation.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationUpdateBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPptx)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().setAuthor("test author");
	root.getDocumentProperties().setCreatedTime(new Date());
	root.getDocumentProperties().setCompany("GroupDocs");
	root.getDocumentProperties().setCategory("test category");
	root.getDocumentProperties().setKeywords("metadata, built-in, update");

	// ...

	metadata.save(Constants.OutputPptx);
}
```

## Adding or updating custom metadata properties

The GroupDocs.Metadata API also allows adding and updating custom metadata properties in a presentation. Please check the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationUpdateCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPpt)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().set("customProperty1", "some value");
	root.getDocumentProperties().set("customProperty2", 123.1);

	metadata.save(Constants.OutputPpt);
}
```

## Updating inspection properties

When you inspect a document GroupDocs.Metadata for Java forms a metadata package containing the extracted information. The package class also provides some basic methods that allow updating (or removing) the extracted properties. The following code sample demonstrates how to remove the inspection properties from a presentation.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.presentation.<WBR>PresentationUpdateInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPpt)) {
	PresentationRootPackage root = metadata.getRootPackageGeneric();

	root.getInspectionPackage().clearComments();
	root.getInspectionPackage().clearHiddenSlides();

	metadata.save(Constants.OutputPpt);
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
