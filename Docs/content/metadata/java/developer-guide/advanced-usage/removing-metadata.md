---
id: removing-metadata
url: metadata/java/removing-metadata
title: Removing metadata
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
Not all metadata properties extracted from a file are marked with tags. Some file formats and metadata standards allow adding fully custom properties that can't be properly tagged by the library since their purpose is not clearly defined in the appropriate format/standard specification. In such cases, you can use the name of the property to locate and remove it. The following example demonstrates some advanced usage scenarios of the GroupDocs.Metadata search engine allowing to remove metadata properties.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/removing-metadata.md" >}}) a file to be modified
2.  Pass a search predicate to the [removeProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#removeProperties(com.groupdocs.metadata.search.Specification)) method.
3.  Check the number of properties that were actually removed
4.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/removing-metadata.md" >}}) the changes

**advanced\_usage.RemovingMetadata**

```csharp
File folder = new File(Constants.InputPath);
for (File file : folder.listFiles()) {
    try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
        if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
            System.out.println();
            System.out.println(file.getName());

            // Remove all mentions of any people contributed in file creation
            // Remove a custom property with the specified name
            int affected = metadata.removeProperties(new FallsIntoCategorySpecification(Tags.getPerson()).or(new WithNameSpecification("CustomProperty")));

            System.out.println(String.format("Affected properties: %s", affected));

            metadata.save(Constants.OutputPath + "output." + FilenameUtils.getExtension(file.getName()));
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
