---
id: working-with-metadata-in-mov-files
url: metadata/java/working-with-metadata-in-mov-files
title: Working with metadata in MOV files
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading MOV format-specific properties

The GroupDocs.Metadata API supports extracting QuickTime atoms from a MOV video. The atom is the basic data unit in any QuickTime file. Please find more information on QuickTime atoms in the official specification: [https://developer.apple.com/library/archive/documentation/QuickTime/QTFF/QTFFPreface/qtffPreface.html](https://developer.apple.com/library/archive/documentation/QuickTime/QTFF/QTFFPreface/qtffPreface.html)

The following are the steps to extract QuickTime atoms from a MOV video.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a MOV video
2.  Get the root metadata package
3.  Extract  the native metadata package using the [MovRootPackage.getMovPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MovRootPackage#getMovPackage()) method
4.  Read the QuickTime atoms

**advanced\_usage.managing\_metadata\_for\_specific\_formats.video.mov.MovReadQuickTimeAtoms**

```csharp
try (Metadata metadata = new Metadata(Constants.InputMov)) {
	MovRootPackage root = metadata.getRootPackageGeneric();

	for (MovAtom atom : root.getMovPackage().getAtoms()) {
		System.out.println(atom.getType());
		System.out.println(atom.getOffset());
		System.out.println(atom.getSize());

		// ...
	}
}
```

## Working with XMP metadata

GroupDocs.Metadata for Java allows managing XMP metadata in MOV files. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}}).

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
