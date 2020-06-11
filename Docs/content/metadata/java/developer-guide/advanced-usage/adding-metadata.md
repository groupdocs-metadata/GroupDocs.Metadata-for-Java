---
id: adding-metadata
url: metadata/java/adding-metadata
title: Adding metadata
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
Adding metadata properties is the most sophisticated feature of the GroupDocs.Metadata search engine. When you call the [addProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#addProperties(com.groupdocs.metadata.search.Specification,%20com.groupdocs.metadata.core.PropertyValue)) method it examines all available metadata packages and tries to pick up a known property that would satisfy the specified predicate. Note that the property will be added to metadata packages that fit the following criteria: 

1.  Only existing metadata packages will be affected. No new packages are added during this operation
2.  There should be a known metadata property in the package structure that fits the search condition but is actually missing in the package. All properties supported by a certain package are usually defined in the specification of a particular metadata standard

**advanced\_usage.AddingMetadata**

```csharp
File folder = new File(Constants.InputPath);
for (File file : folder.listFiles()) {
    try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
        if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
            System.out.println();
            System.out.println(file.getName());

            // Add a property containing the file last printing date if it's missing
            // Note that the property will be added to metadata packages that satisfy the following criteria:
            // 1) Only existing metadata packages will be affected. No new packages are added during this operation
            // 2) There should be a known metadata property in the package structure that fits the search condition but is actually missing in the package.
            // All properties supported by a certain package are usually defined in the specification of a particular metadata standard
            int affected = metadata.addProperties(new ContainsTagSpecification(Tags.getTime().getPrinted()), new PropertyValue(new Date()));

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
