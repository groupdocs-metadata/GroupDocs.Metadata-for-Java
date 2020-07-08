---
id: remove-metadata-properties
url: metadata/java/remove-metadata-properties
title: Remove metadata properties
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Remove metadata properties using various criteria

The easiest way to remove certain metadata properties from a file is to use corresponding tags that allow you to locate the desired properties across all metadata packages. But sometimes it's necessary to remove metadata entries having a particular value. Using the GroupDocs.Metadata search engine you can find and remove properties satisfying a specification that can be as complex as you need.

The following example demonstrates how to remove specific metadata properties using a combination of criteria.

1.  [Load]({{< ref "metadata/java/developer-guide/basic-usage/remove-metadata-properties.md" >}}) a file to update
2.  Use a specification to find and remove any desired metadata properties
3.  Check the number of properties that were actually removed (please see the return value of the [removeProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#removeProperties(com.groupdocs.metadata.search.Specification)) method)
4.  [Save]({{< ref "metadata/java/developer-guide/basic-usage/remove-metadata-properties.md" >}}) the changes

**basic\_usage.RemoveMetadataProperties**

```csharp
public class RemoveMetadataProperties {
    public static void run() {
        // Constants.InputDocx is an absolute or relative path to your document. Ex: @"C:\Docs\source.docx"
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {

            // Remove all the properties satisfying the predicate:
            // property contains the name of the document author OR
            // it refers to the last editor OR
            // the property value is a string that is equal to the given string "John" (to remove any mentions of John from the detected metadata)
            int affected = metadata.removeProperties(
                    new ContainsTagSpecification(Tags.getPerson().getCreator()).or(
                            new ContainsTagSpecification(Tags.getPerson().getEditor())).or(
                            new OfTypeSpecification(MetadataPropertyType.String).and(new RemoveMetadataProperties().new WithValueSpecification("John"))));

            System.out.println(String.format("Properties removed: %s", affected));

            metadata.save(Constants.OutputDocx);
        }
    }

    // Define your own specifications to filter metadata properties
    public class WithValueSpecification extends Specification {
        public WithValueSpecification(Object value) {
            setValue(value);
        }

        public final Object getValue() {
            return auto_Value;
        }

        private void setValue(Object value) {
            auto_Value = value;
        }

        private Object auto_Value;

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate.getValue().getRawValue().equals(getValue());
        }
    }
}
```

As a result of execution of the code snippet above, we remove all mentions of the document author/editor and all other string metadata properties containing the name John.

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
