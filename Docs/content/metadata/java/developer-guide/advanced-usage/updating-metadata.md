---
id: updating-metadata
url: metadata/java/updating-metadata
title: Updating metadata
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
# Updating existing metadata properties

The example below demonstrates how to update existing metadata properties using a combination of criteria. Please note that the [updateProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#updateProperties(com.groupdocs.metadata.search.Specification,%20com.groupdocs.metadata.core.PropertyValue)) method checks the type of all properties before applying any changes. If a property satisfies the predicate but has a type different from the passed value it won't be updated. The explicit type check in the example is performed since we use the existing value to filter metadata properties.

1.  [Open]({{< ref "metadata/java/developer-guide/advanced-usage/updating-metadata.md" >}}) a file to be updated
2.  Specify a predicate that will be used to filter desired metadata properties
3.  Specify a value which you want to be assigned to the selected properties
4.  Pass the predicate and the new value to the [updateProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#updateProperties(com.groupdocs.metadata.search.Specification,%20com.groupdocs.metadata.core.PropertyValue)) method
5.  Check the actual number of updated properties
6.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/updating-metadata.md" >}}) the changes

**advanced\_usage.UpdatingMetadata**

```csharp
public class UpdatingMetadata {
    public static void run() {
        Date threeDaysAgo = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(3));

        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles()) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());

                    // Update the file creation date/time if the existing value is older than 3 days
                    int affected = metadata.updateProperties(new ContainsTagSpecification(Tags.getTime().getCreated()).and(
                            new OfTypeSpecification(MetadataPropertyType.DateTime)).and(
                            new UpdatingMetadata().new DateBeforeSpecification(threeDaysAgo)), new PropertyValue(new Date()));

                    System.out.println(String.format("Affected properties: %s", affected));

                    metadata.save(Constants.OutputPath + "output." + FilenameUtils.getExtension(file.getName()));
                }
            }
        }
    }

    // Define your own specifications to filter metadata properties
    public class DateBeforeSpecification extends Specification {
        public DateBeforeSpecification(Date date) {
            setValue(date);
        }

        public final Date getValue() {
            return auto_Value;
        }

        private void setValue(Date value) {
            auto_Value = value;
        }

        private Date auto_Value;

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            Date date = candidate.getValue().toClass(Date.class);
            if (date != null) {
                return date.before(getValue());
            }
            return false;
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
