---
id: working-with-zip-archives
url: metadata/java/working-with-zip-archives
title: Working with ZIP archives
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Get ZIP format metadata

The API allows detecting ZIP archives and reading format metadata. The following steps are needed to be followed:

*   [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a ZIP archive
*   Get the root metadata package
*   Extract  the native metadata package using the [ZipRootPackage.getZipPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ZipRootPackage#getZipPackage()) method
*   Read the ZIP archive properties
*   Loop through [ZipPackage.getFiles](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ZipPackage#getFiles()) to extract information about the archived files 

The following code snippet shows how to get metadata from a ZIP archive.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>archive.ZipReadNativeMetadataProperties**

```csharp
Charset charset = Charset.forName("cp866");

try (Metadata metadata = new Metadata(Constants.InputZip)) {
    ZipRootPackage root = metadata.getRootPackageGeneric();

    System.out.println(root.getZipPackage().getComment());
    System.out.println(root.getZipPackage().getTotalEntries());

    for (ZipFile file : root.getZipPackage().getFiles()) {
        System.out.println(file.getName());
        System.out.println(file.getCompressedSize());
        System.out.println(file.getCompressionMethod());
        System.out.println(file.getFlags());
        System.out.println(file.getModificationDateTime());
        System.out.println(file.getUncompressedSize());

        // Use a specific encoding for the file names
        System.out.println(new String(file.getRawName(), charset));
    }
}
```

## Updating the user comment

GroupDocs.Metadata for Java allows you to update the user comment in a ZIP archive. The following steps are needed to be followed:

*   [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a ZIP archive
*   Get the root metadata package
*   Update the comment using the [ZipPackage.setComment](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ZipPackage#setComment(java.lang.String)) method
*   Save the changes

The following code snippet demonstrates the usage of this feature.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>archive.ZipUpdateArchiveComment**

```csharp
try (Metadata metadata = new Metadata(Constants.InputZip)) {
	ZipRootPackage root = metadata.getRootPackageGeneric();

	root.getZipPackage().setComment("updated comment");

	metadata.save(Constants.OutputZip);
}
```

## Removing the user comment

GroupDocs.Metadata for Java allows you to remove the user comment associated with a ZIP archive. The following code snippet demonstrates the usage of this feature.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>archive.ZipRemoveArchiveComment**

```csharp
try (Metadata metadata = new Metadata(Constants.InputZip)) {
	ZipRootPackage root = metadata.getRootPackageGeneric();

	root.getZipPackage().setComment(null);

	metadata.save(Constants.OutputZip);
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
