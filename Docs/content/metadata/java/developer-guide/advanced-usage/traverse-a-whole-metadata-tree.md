---
id: traverse-a-whole-metadata-tree
url: metadata/java/traverse-a-whole-metadata-tree
title: Traverse a whole metadata tree
weight: 6
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
In some cases, it's required to get access to all properties extracted from a document, video, image, etc. GroupDocs.Metadata represents any loaded file as a tree consisting of metadata properties and nested metadata packages. You can easily iterate through the metadata tree using the code snippet below:

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/traverse-a-whole-metadata-tree.md" >}}) a file to examine
2.  Obtain the [RootMetadataPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/RootMetadataPackage) instance which is the root of the whole metadata tree extracted from the file
3.  Use any algorithm of your choice to traverse the tree.

**advanced\_usage.TraverseWholeMetadataTree**

```csharp
public static void run() {
	try (Metadata metadata = new Metadata(Constants.JpegWithXmp)) {
		displayMetadataTree(metadata.getRootPackage(), 0);
	}
}
private static void displayMetadataTree(MetadataPackage metadata, int indent) {
	if (metadata != null) {
		String stringMetadataType = String.valueOf(metadata.getMetadataType());
		System.out.printf("%" + (stringMetadataType.length() + indent) + "s%n", stringMetadataType);
		for (MetadataProperty property : metadata) {
			String stringPropertyRepresentation = "Name: " + property.getName() + ", Value: " + property.getValue();
			System.out.printf("%" + (stringPropertyRepresentation.length() + indent + 1) + "s%n", stringPropertyRepresentation);
			if (property.getValue() != null) {
				switch (property.getValue().getType()) {
					case MetadataPropertyType.Metadata:
						displayMetadataTree(property.getValue().toClass(MetadataPackage.class), indent + 2);
						break;
					case MetadataPropertyType.MetadataArray:
						displayMetadataTree(property.getValue().toArray(MetadataPackage.class), indent + 2);
						break;
				}
			}
		}
	}
}
private static void displayMetadataTree(MetadataPackage[] metadataArray, int indent) {
	if (metadataArray != null) {
		for (MetadataPackage metadata : metadataArray) {
			displayMetadataTree(metadata, indent);
		}
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
