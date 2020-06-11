---
id: find-metadata-properties
url: metadata/java/find-metadata-properties
title: Find metadata properties
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Use tags to find most common metadata properties

To make manipulating metadata easier we attach specific tags to the most commonly used metadata properties extracted from a file. Some metadata standards can have quite a complex structure. Moreover, in most cases, one image, video or document contains more than one metadata packages. Using tags you can search for desirable properties with a few lines of code without even knowing the exact format of the loaded file.

The code sample below demonstrates how to search for specific metadata properties using tags:

1.  [Load]({{< ref "metadata/java/developer-guide/basic-usage/find-metadata-properties.md" >}}) a file to examine
2.  Make up a predicate checking that a specific tag is assigned to a property (alternatively you can use a combination of tags)
3.  Pass the predicate to the [f](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#findProperties(com.groupdocs.metadata.search.Specification))[indProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#findProperties(com.groupdocs.metadata.search.Specification)) method
4.  Iterate through the found properties

**basic\_usage.FindMetadataProperties**

```csharp
// Constants.InputPptx is an absolute or relative path to your document. Ex: @"C:\Docs\source.pptx"
try (Metadata metadata = new Metadata(Constants.InputPptx)) {
	// Fetch all the properties satisfying the predicate:
	// property contains the name of the last document editor OR the date/time the document was last modified
	IReadOnlyList<MetadataProperty> properties = metadata.findProperties(
			new ContainsTagSpecification(Tags.getPerson().getEditor()).or(new ContainsTagSpecification(Tags.getTime().getModified())));
	for (MetadataProperty property : properties) {
		System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
	}
}
```

As a result, we obtain all metadata properties containing the name of the person last edited the document and all properties that store the date/time the document was last edited.

For more information on supported features of the GroupDocs.Metadata search engine please refer to the following articles:

*   [Extracting metadata]({{< ref "metadata/java/developer-guide/advanced-usage/extracting-metadata.md" >}})
*   [Removing metadata]({{< ref "metadata/java/developer-guide/advanced-usage/removing-metadata.md" >}})
*   [Updating metadata]({{< ref "metadata/java/developer-guide/advanced-usage/updating-metadata.md" >}})
*   [Adding metadata]({{< ref "metadata/java/developer-guide/advanced-usage/adding-metadata.md" >}})

## More resources

### Advanced usage topics

To learn more about library features and get familiar how to manage metadata and more, please refer to the[advanced usage section]({{< ref "metadata/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with a full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
