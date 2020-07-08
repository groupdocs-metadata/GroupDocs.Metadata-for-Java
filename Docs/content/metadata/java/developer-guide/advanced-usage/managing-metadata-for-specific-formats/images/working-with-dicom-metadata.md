---
id: working-with-dicom-metadata
url: metadata/java/working-with-dicom-metadata
title: Working with DICOM metadata
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading DICOM metadata properties

The GroupDocs.Metadata API supports extracting format-specific information from DICOM images.

The following are the steps to read the native DICOM metadata.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a DICOM image
2.  Get the root metadata package
3.  Extract  the native metadata package using the [DicomRootPackage.getDicomPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/DicomRootPackage#getDicomPackage()) method
4.  Read the DICOM metadata properties

**examples.advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>image.dicom.DicomReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDicom)) {
	DicomRootPackage root = metadata.getRootPackageGeneric();

	if (root.getDicomPackage() != null) {
		System.out.println(root.getDicomPackage().getBitsAllocated());
		System.out.println(root.getDicomPackage().getReds());
		System.out.println(root.getDicomPackage().getGreens());
		System.out.println(root.getDicomPackage().getBlues());
		System.out.println(root.getDicomPackage().getNumberOfFrames());
		// ...
	}
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
