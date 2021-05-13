---
id: working-with-metadata-in-epub-e-books
url: metadata/java/working-with-metadata-in-epub-e-books
title: Working with metadata in EPUB e-books
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## What is EPUB?

EPUB is an e-book file format that uses the ".epub" file extension. EPUB is supported by many e-readers, and compatible software is available for most smartphones, tablets, and computers. 

{{< alert style="info" >}}Please find more information on the format at https://en.wikipedia.org/wiki/EPUB{{< /alert >}}

## Reading EPUB format-specific properties

The GroupDocs.Metadata API supports extracting format-specific information from EPUB files.

The following are the steps to read native EPUB metadata.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an EPUB file
2.  Get the root metadata package
3.  Extract  the native metadata package using the [EpubRootPackage.getEpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubRootPackage#getEpubPackage()) method
4.  Read the EPUB metadata properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>ebook.EpubReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputEpub)) {
	EpubRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getEpubPackage().getVersion());
	System.out.println(root.getEpubPackage().getUniqueIdentifier());
	System.out.println(root.getEpubPackage().getImageCover() != null ? root.getEpubPackage().getImageCover().length : 0);
}
```

## Updating EPUB format-specific properties

The GroupDocs.Metadata API also supports updating some metadata properties of an EPUB file. Please see the code snippet below to learn how to do that.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>ebook.EpubUpdateNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputEpub)) {
    EpubRootPackage root = metadata.getRootPackageGeneric();
 
    root.getEpubPackage().setCreator("GroupDocs");
    root.getEpubPackage().setDescription("test e-book");
    root.getEpubPackage().setFormat("EPUB");
    root.getEpubPackage().setDate(new Date().toString());
 
    // ...
 
    metadata.save(Constants.OutputEpub);
}
```

## Reading Dublin Core Metadata

Dublin Core metadata is a set of certain metadata properties that are intended to describe various digital resources. Please find more information on the Dublin Core standard at [https://en.wikipedia.org/wiki/Dublin\_Core](https://en.wikipedia.org/wiki/Dublin_Core). The code sample below shows how to extract Dublin Core metadata from a EPUB e-book using the GroupDocs.Metadata API.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>ebook.EpubReadDublinCoreProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputEpub)) {
    EpubRootPackage root = metadata.getRootPackageGeneric();
 
    System.out.println(root.getDublinCorePackage().getRights());
    System.out.println(root.getDublinCorePackage().getPublisher());
    System.out.println(root.getDublinCorePackage().getTitle());
    System.out.println(root.getDublinCorePackage().getCreator());
    System.out.println(root.getDublinCorePackage().getLanguage());
    System.out.println(root.getDublinCorePackage().getDate());
 
    // ...
}
```

Please see the the [DublinCorePackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DublinCorePackage) class to get more information on supported Dublin Core metadata properties.

## Updating Dublin Core Metadata

The GroupDocs.Metadata API also allows updating DublinCore metadata properties in an EPUB file. Please check the code sample below.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>ebook.EpubUpdateDublinCoreProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputEpub)) {
 
    EpubRootPackage root = metadata.getRootPackageGeneric();
 
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:creator"), new PropertyValue("GroupDocs"));
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:description"), new PropertyValue("test e-book"));
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:title"), new PropertyValue("test EPUB"));
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:date"), new PropertyValue(new Date().toString()));
 
    // ...
 
    metadata.save(Constants.OutputEpub);
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
