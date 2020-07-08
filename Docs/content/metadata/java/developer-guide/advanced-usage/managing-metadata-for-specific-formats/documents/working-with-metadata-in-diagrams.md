---
id: working-with-metadata-in-diagrams
url: metadata/java/working-with-metadata-in-diagrams
title: Working with metadata in Diagrams
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata for Java provides functionality that allows working with different kinds of diagrams such as VDX, VSDX, VSX, etc. For the full list of supported document formats please refer to [Supported document formats]({{< ref "metadata/java/getting-started/supported-document-formats.md" >}}).

## Detecting the exact type of a document

The following sample of code will help you to detect the exact type of a loaded diagram and extract some additional file format information.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a PDF document
2.  Extract the root metadata package
3.  Use the [getDiagramType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DiagramRootPackage#getDiagramType()) method to obtain file format information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.diagram.<WBR>DiagramReadFileFormatProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputVdx)) {
	DiagramRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDiagramType().getFileFormat());
	System.out.println(root.getDiagramType().getDiagramFormat());
	System.out.println(root.getDiagramType().getMimeType());
	System.out.println(root.getDiagramType().getExtension());
}
```

## Reading built-In metadata properties

To access built-in metadata of a diagram, please use the [getDocumentProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage#getDocumentProperties()) method defined in the [DocumentRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage) class.

The following code snippet extracts built-in metadata properties and displays them on the screen.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.diagram.<WBR>DiagramReadBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputVsdx)) {
	DiagramRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentProperties().getCreator());
	System.out.println(root.getDocumentProperties().getCompany());
	System.out.println(root.getDocumentProperties().getKeywords());
	System.out.println(root.getDocumentProperties().getLanguage());
	System.out.println(root.getDocumentProperties().getTimeCreated());
	System.out.println(root.getDocumentProperties().getCategory());

	// ...
}
```

## Reading custom metadata properties

If you need to extract custom metadata properties of a diagram please follow the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.diagram.<WBR>DiagramReadCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputVsdx)) {
	DiagramRootPackage root = metadata.getRootPackageGeneric();

	IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());

	for (MetadataProperty property : customProperties) {
		System.out.println(String.format("%s = %s", property.getName(), property.getValue().getRawValue()));
	}
}
```

As you can see the code sample uses the GroupDocs.Metadata search engine to retrieve all properties that are not marked with the BuiltIn tag. Since we call the [findProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataPackage#findProperties(com.groupdocs.metadata.search.Specification)) method for a certain metadata package (instance of the [DiagramPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DiagramPackage) class), the search result will contain only metadata properties that are specific for diagram documents. 

## Reading document statistics

Most office applications are able to display simple text statistics for loaded documents. It can be an estimated word count, page count, character count, etc. The GroupDocs.Metadata API provides similar functionality for some document formats. The following code sample demonstrates how to obtain the text statistics for a diagram (only the page count statistic is available at the moment).

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.diagram.<WBR>DiagramReadDocumentStatistics**

```csharp
try (Metadata metadata = new Metadata(Constants.InputVdx)) {
	DiagramRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentStatistics().getPageCount());
}
```

## Updating built-In metadata properties

Updating any built-in document properties is as simple as getting them. The following code sample demonstrates how to update built-in metadata properties in a diagram document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.diagram.<WBR>DiagramUpdateBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputVdx)) {
	DiagramRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().setCreator("test author");
	root.getDocumentProperties().setTimeCreated(new Date());
	root.getDocumentProperties().setCompany("GroupDocs");
	root.getDocumentProperties().setCategory("test category");
	root.getDocumentProperties().setKeywords("metadata, built-in, update");

	// ...

	metadata.save(Constants.OutputVdx);
}
```

## Adding or updating custom metadata properties

The GroupDocs.Metadata API also allows adding and updating custom metadata properties in a diagram document. Please check the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.diagram.<WBR>DiagramUpdateCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputVsdx)) {
	DiagramRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().set("customProperty1", "some value");
	root.getDocumentProperties().set("customProperty2", true);

	metadata.save(Constants.OutputVsdx);
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
