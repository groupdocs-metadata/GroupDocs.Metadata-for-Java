---
id: clean-metadata
url: metadata/java/clean-metadata
title: Clean metadata
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Remove all recognized metadata properties from a file

Sometimes you may need to just remove all metadata properties without applying any filters. The best way to do this is to use the [sanitize](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#sanitize()) method.

This example demonstrates how to remove all detected metadata packages/properties.

1.  [Load]({{< ref "metadata/java/developer-guide/basic-usage/clean-metadata.md" >}}) a file to clean
2.  Call the [sanitize](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#sanitize()) method
3.  Check the actual number of removed packages/properties
4.  [Save]({{< ref "metadata/java/developer-guide/basic-usage/clean-metadata.md" >}}) the changes

**basic\_usage.CleanMetadata**

```csharp
// Constants.InputPdf is an absolute or relative path to your document. Ex: @"C:\Docs\source.pdf"
try (Metadata metadata = new Metadata(Constants.InputPdf)) {
	// Remove detected metadata packages
	int affected = metadata.sanitize();
	System.out.println(String.format("Properties removed: %s", affected));
	metadata.save(Constants.OutputPdf);
}
```

As a result, we get a sanitized version of the original file.

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
