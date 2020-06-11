---
id: extracting-metadata
url: metadata/java/extracting-metadata
title: Extracting metadata
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
Using the GroupDocs.Metadata search engine you can extract desired metadata properties from files of different types. You don't need to worry about the exact file format and metadata standards it can deal with. The same code will work for all supported formats in the same way. Most commonly used metadata properties are marked with tags that allow searching them across all supported files in various metadata packages. All tags defined in GroupDocs.Metadata are divided into categories that make it easier to find a required tag. The code sample below demonstrates some advanced usage of tags, categories and other attributes of metadata properties.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/extracting-metadata.md" >}}) a file to be searched for metadata properties
2.  Make up a predicate to examine all extracted metadata properties
3.  Pass the predicate to the [findProperties](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#findProperties(com.groupdocs.metadata.search.Specification)) method
4.  Iterate through the found properties

**advanced\_usage.ExtractingMetadata**

```csharp
public class ExtractingMetadata {
    public static void run() {
        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles()) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());

                    // Fetch all metadata properties that fall into a particular category
                    IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FallsIntoCategorySpecification(Tags.getContent()));
                    System.out.println("The metadata properties describing some characteristics of the file content: title, keywords, language, etc.");
                    for (MetadataProperty property : properties) {
                        System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
                    }

                    // Fetch all properties having a specific type and value
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    properties = metadata.findProperties(new OfTypeSpecification(MetadataPropertyType.DateTime).and(new ExtractingMetadata().new YearMatchSpecification(year)));
                    System.out.println("All datetime properties with the year value equal to the current year");
                    for (MetadataProperty property : properties) {
                        System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
                    }

                    // Fetch all properties whose names match the specified regex
                    Pattern pattern = Pattern.compile("^author|company|(.+date.*)$", Pattern.CASE_INSENSITIVE);
                    properties = metadata.findProperties(new ExtractingMetadata().new RegexSpecification(pattern));
                    System.out.println(String.format("All properties whose names match the following regex: %s", pattern.pattern()));
                    for (MetadataProperty property : properties) {
                        System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
                    }
                }
            }
        }
    }

    // Define your own specifications to filter metadata properties
    public class YearMatchSpecification extends Specification {
        public YearMatchSpecification(int year) {
            setValue(year);
        }

        public final int getValue() {
            return auto_Value;
        }

        private void setValue(int value) {
            auto_Value = value;
        }

        private int auto_Value;

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            Date date = candidate.getValue().toClass(Date.class);
            if (date != null) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return getValue() == calendar.get(Calendar.YEAR);
            }
            return false;
        }
    }

    public class RegexSpecification extends Specification {
        private Pattern pattern;
        public RegexSpecification(Pattern pattern) {
            this.pattern = pattern;
        }

        @Override
        public boolean isSatisfiedBy(MetadataProperty metadataProperty) {
            Matcher matcher = pattern.matcher(metadataProperty.getName());
            return matcher.find();
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
