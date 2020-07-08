---
id: working-with-metadata-in-spreadsheets
url: metadata/java/working-with-metadata-in-spreadsheets
title: Working with metadata in Spreadsheets
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata for Java provides functionality that allows working with different kinds of spreadsheet formats such as XLS, XLSX, ODS, etc. For the full list of supported document formats please refer to [Supported document formats]({{< ref "metadata/java/getting-started/supported-document-formats.md" >}}).

## Detecting the exact type of a document

The following sample of code will help you to detect the exact type of a loaded spreadsheet and extract some additional file format information.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a Spreadsheet document
2.  Extract the root metadata package
3.  Use the [getSpreadsheetType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/SpreadsheetRootPackage#getSpreadsheetType()) method to obtain file format information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.spreadsheet.<WBR>SpreadsheetReadFileFormatProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getSpreadsheetType().getFileFormat());
	System.out.println(root.getSpreadsheetType().getSpreadsheetFormat());
	System.out.println(root.getSpreadsheetType().getMimeType());
	System.out.println(root.getSpreadsheetType().getExtension());
}
```

## Reading built-in metadata properties

To access built-in metadata of a spreadsheet, please use the [getDocumentProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage#getDocumentProperties()) method defined in the [DocumentRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage) class.

The following code snippet extracts built-in metadata properties and displays them on the screen.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.spreadsheet.<WBR>SpreadsheetReadBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentProperties().getAuthor());
	System.out.println(root.getDocumentProperties().getCreatedTime());
	System.out.println(root.getDocumentProperties().getCompany());
	System.out.println(root.getDocumentProperties().getCategory());
	System.out.println(root.getDocumentProperties().getKeywords());
	System.out.println(root.getDocumentProperties().getLanguage());
	System.out.println(root.getDocumentProperties().getContentType());

	// ... 
}
```

## Reading custom metadata properties

If you need to extract custom metadata properties of a spreadsheet please follow the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.spreadsheet.<WBR>SpreadsheetReadCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputXls)) {
    SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

    IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());

    for (MetadataProperty property : customProperties) {
        System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
    }

    // Extract only content type properties if required
    for (SpreadsheetContentTypeProperty contentTypeProperty : root.getDocumentProperties().getContentTypeProperties().toList()) {
        System.out.println(String.format("%s, %s = %s", contentTypeProperty.getSpreadsheetPropertyType(), contentTypeProperty.getName(), contentTypeProperty.getSpreadsheetPropertyValue()));
    }
}
```

As you can see the code sample uses the GroupDocs.Metadata search engine to retrieve all properties that are not marked with the BuiltIn tag. Since we call the [findProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataPackage#findProperties(com.groupdocs.metadata.search.Specification)) method for a certain metadata package (instance of the [SpreadsheetPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/SpreadsheetRootPackage) class), the search result will contain only metadata properties that are specific for spreadsheets. 

## Inspecting spreadsheets

The inspection feature that is introduced in this section doesn't work with metadata directly but extracts some useful pieces of information that can be considered as metadata under some circumstances. For example, you may want to obtain information about digital signatures associated with a spreadsheet, extract user comments from the spreadsheet content, obtain hidden sheets, etc. Please follow the example below to learn how to do that.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a Spreadsheet document
2.  Extract the root metadata package
3.  Use the [getInspectionPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/SpreadsheetRootPackage#getInspectionPackage()) method to inspect the document

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.spreadsheet.<WBR>SpreadsheetReadInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputXls)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

	if (root.getInspectionPackage().getComments() != null) {
		for (SpreadsheetComment comment : root.getInspectionPackage().getComments()) {
			System.out.println(comment.getAuthor());
			System.out.println(comment.getText());
			System.out.println(comment.getSheetNumber());
			System.out.println(comment.getRow());
			System.out.println(comment.getColumn());
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

	if (root.getInspectionPackage().getHiddenSheets() != null) {
		for (SpreadsheetSheet sheet : root.getInspectionPackage().getHiddenSheets()) {
			System.out.println(sheet.getName());
			System.out.println(sheet.getNumber());
		}
	}
}
```

## Updating built-In metadata properties

Updating any built-in document properties is as simple as getting them. The following code sample demonstrates how to update built-in metadata properties in a spreadsheet.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.spreadsheet.<WBR>SpreadsheetUpdateBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().setAuthor("test author");
	root.getDocumentProperties().setCreatedTime(new Date());
	root.getDocumentProperties().setCompany("GroupDocs");
	root.getDocumentProperties().setCategory("test category");
	root.getDocumentProperties().setKeywords("metadata, built-in, update");

	// ... 

	metadata.save(Constants.OutputXlsx);
}
```

## Adding or updating custom metadata properties

The GroupDocs.Metadata API also allows adding and updating custom metadata properties (including content type properties) in a spreadsheet. Please check the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.spreadsheet.<WBR>SpreadsheetUpdateCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputXls)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().set("customProperty1", "some value");
	root.getDocumentProperties().set("customProperty2", 7);

	// Set a content type property
	root.getDocumentProperties().getContentTypeProperties().set("customContentTypeProperty", "custom value");

	metadata.save(Constants.OutputXls);
}
```

## Updating inspection properties

When you inspect a spreadsheet GroupDocs.Metadata for Java forms a metadata package containing the extracted information. The package class also provides some basic methods that allow removing the extracted properties. The following code sample demonstrates how to remove the inspection properties in a spreadsheet.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.spreadsheet.<WBR>SpreadsheetUpdateInspectionProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

	root.getInspectionPackage().clearComments();
	root.getInspectionPackage().clearDigitalSignatures();
	root.getInspectionPackage().clearHiddenSheets();

	metadata.save(Constants.OutputXlsx);
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
