---
id: working-with-cad-metadata
url: metadata/java/working-with-cad-metadata
title: Working with CAD metadata
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
The GroupDocs Metadata API provides the feature to read basic metadata in CAD files. The supported CAD formats are:

*   DWG
*   DXF

## Reading CAD metadata

To access metadata in a CAD drawing, the GroupDocs.Metadata API provides the [CadRootPackage.getCadPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/CadRootPackage#getCadPackage()) method.

The following code snippet reads metadata associated with a CAD file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>cad.CadReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDxf)) {
	CadRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getCadPackage().getAcadVersion());
	System.out.println(root.getCadPackage().getAuthor());
	System.out.println(root.getCadPackage().getComments());
	System.out.println(root.getCadPackage().getCreatedDateTime());
	System.out.println(root.getCadPackage().getHyperlinkBase());
	System.out.println(root.getCadPackage().getKeywords());
	System.out.println(root.getCadPackage().getLastSavedBy());
	System.out.println(root.getCadPackage().getTitle());

	// ...
}
```

## Updating DXF metadata

The GroupDocs.Metadata API also allows updating metadata properties in a DXF drawing. Please check the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>cad.DxfUpdateNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDxf)) {
 
    CadRootPackage root = metadata.getRootPackageGeneric();
 
    root.getCadPackage().setProperties(new WithNameSpecification("Author"), new PropertyValue("GroupDocs"));
    root.getCadPackage().setProperties(new WithNameSpecification("Comments"), new PropertyValue("test comment"));
    root.getCadPackage().setProperties(new WithNameSpecification("HyperlinkBase"), new PropertyValue("test hyperlink base"));
    root.getCadPackage().setProperties(new WithNameSpecification("Keywords"), new PropertyValue("test keywords"));
    root.getCadPackage().setProperties(new WithNameSpecification("LastSavedBy"), new PropertyValue("test editor"));
    root.getCadPackage().setProperties(new WithNameSpecification("RevisionNumber"), new PropertyValue("test revision number"));
    root.getCadPackage().setProperties(new WithNameSpecification("Subject"), new PropertyValue("test subject"));
    root.getCadPackage().setProperties(new WithNameSpecification("Title"), new PropertyValue("test title"));
    root.getCadPackage().setProperties(new WithNameSpecification("CreatedDateTime"), new PropertyValue(new Date()));
    root.getCadPackage().setProperties(new WithNameSpecification("ModifiedDateTime"), new PropertyValue(new Date()));
 
    metadata.save(Constants.OutputDxf);
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
