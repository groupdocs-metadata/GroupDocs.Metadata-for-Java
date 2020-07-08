---
id: working-with-metadata-in-projectmanagement-formats
url: metadata/java/working-with-metadata-in-projectmanagement-formats
title: Working with metadata in ProjectManagement formats
weight: 6
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata for Java provides functionality that allows working with MPP files created by different versions of Microsoft Project. Please see the code samples below for more information.

## Reading built-In metadata properties

To access built-in metadata of a ProjectManagement document, please use the [getDocumentProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage#getDocumentProperties()) method defined in the [DocumentRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DocumentRootPackage) class.

The following code snippet extracts built-in metadata properties and displays them on the screen.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.project\_management.<WBR>ProjectManagementReadBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputMpp)) {
	ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getDocumentProperties().getAuthor());
	System.out.println(root.getDocumentProperties().getCreationDate());
	System.out.println(root.getDocumentProperties().getCompany());
	System.out.println(root.getDocumentProperties().getCategory());
	System.out.println(root.getDocumentProperties().getKeywords());
	System.out.println(root.getDocumentProperties().getRevision());
	System.out.println(root.getDocumentProperties().getSubject());

	// ...
}
```

## Reading custom metadata properties

If you need to extract custom metadata properties of a ProjectManagement document please follow the code sample below.

**advanced_usage.managing_metadata_for_specific_formats.<WBR>document.project_management.<WBR>ProjectManagementReadCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputMpp)) {
    ProjectManagementRootPackage root = metadata.getRootPackageGeneric();
  
    IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());
  
    for (MetadataProperty property : customProperties) {
        System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
    }
}
```

## Updating built-in metadata properties

Updating any built-in document properties is as simple as getting them. The following code sample demonstrates how to update built-in metadata properties in a ProjectManagement document.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>document.project\_management.<WBR>ProjectManagementUpdateBuiltInProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputMpp)) {
	ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

	root.getDocumentProperties().setAuthor("test author");
	root.getDocumentProperties().setCreationDate(new Date());
	root.getDocumentProperties().setCompany("GroupDocs");
	root.getDocumentProperties().setComments("test comment");
	root.getDocumentProperties().setKeywords("metadata, built-in, update");

	// ...

	metadata.save(Constants.OutputMpp);
}
```

## Adding or updating custom metadata properties

The GroupDocs.Metadata API also allows adding and updating custom metadata properties in a ProjectManagement document. Please check the code sample below.
**advanced_usage.managing_metadata_for_specific_formats.<WBR>document.project_management.<WBR>ProjectManagementUpdateCustomProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputMpp)) {
  
    ProjectManagementRootPackage root = metadata.getRootPackageGeneric();
  
    root.getDocumentProperties().set("customProperty1", "some value");
    root.getDocumentProperties().set("customProperty2", 7);
    root.getDocumentProperties().set("customProperty3", true);
  
    metadata.save(Constants.OutputMpp);
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
