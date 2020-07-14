---
id: getting-known-property-descriptors
url: metadata/java/getting-known-property-descriptors
title: Getting known property descriptors
weight: 7
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
This code snippet demonstrates how to extract information about known properties that can be encountered in a particular package.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file to examine
2.  Get a collection of [PropertyDescriptor](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PropertyDescriptor) instances for any desired metadata package
3.  Iterate through the extracted descriptors

**advanced\_usage.GettingKnownPropertyDescriptors**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {
	WordProcessingRootPackage root = metadata.getRootPackageGeneric();

	for (PropertyDescriptor descriptor : root.getDocumentProperties().getKnowPropertyDescriptors()) {
		System.out.println(descriptor.getName());
		System.out.println(descriptor.getType());
		System.out.println(descriptor.getAccessLevel());
		for (PropertyTag tag : descriptor.getTags()) {
			System.out.println(tag);
		}
		System.out.println();
	}
}
```

{{< alert style="info" >}}Not all possible properties are presented in the getKnowPropertyDescriptors collection. The library provides information on the most frequently used properties only. If there is no descriptor for some property it is still accessible through the GroupDocs.Metadata search engine in read-only mode.{{< /alert >}}

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
