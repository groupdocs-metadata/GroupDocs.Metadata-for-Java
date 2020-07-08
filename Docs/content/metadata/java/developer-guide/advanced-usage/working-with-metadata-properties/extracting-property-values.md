---
id: extracting-property-values
url: metadata/java/extracting-property-values
title: Extracting property values
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
The most common way to get the metadata property value is to check its type and convert it to the appropriate platform-specific type.

**advanced\_usage.extracting\_property\_values.ExtractUsingType**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDocx)) {
	// Fetch all metadata properties from the file
	IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());
	for (MetadataProperty property : properties) {
		// Process String and DateTime properties only
		if (property.getValue().getType() == MetadataPropertyType.String) {
			System.out.println(property.getValue().toClass(String.class));
		} else if (property.getValue().getType() == MetadataPropertyType.DateTime) {
			System.out.println(property.getValue().toClass(Date.class));
		}
	}
}
```

But if it's necessary to process all supported types of values you may find the alternative way more convenient.

**advanced\_usage.extracting\_property\_values.ExtractUsingAcceptor**

```csharp
public class ExtractUsingAcceptor {

    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            // Fetch all metadata properties
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());

            ValueAcceptor valueAcceptor = new ExtractUsingAcceptor().new CustomValueAcceptor();
            for (MetadataProperty property : properties) {
                // Extract the property value using a custom acceptor
                property.getValue().acceptValue(valueAcceptor);
            }
        }
    }

    private class CustomValueAcceptor extends ValueAcceptor {
        protected void acceptNull() {
            System.out.println("Null value extracted");
        }

        protected void accept(String value) {
            System.out.println(String.format("String value extracted: %s", value));
        }

        protected void accept(boolean value) {
            System.out.println(String.format("Boolean value extracted: %s", value));
        }

        protected void accept(Date value) {
            System.out.println(String.format("DateTime value extracted: %s", value));
        }

        protected void accept(int value) {
            System.out.println(String.format("Integer value extracted: %s", value));
        }

        protected void accept(long value) {
            System.out.println(String.format("Long value extracted: %s", value));
        }

        protected void accept(double value) {
            System.out.println(String.format("Double value extracted: %s", value));
        }

        protected void accept(String[] value) {
            System.out.println(String.format("String array extracted: %s", (Object) value));
        }

        protected void accept(byte[] value) {
            System.out.println(String.format("Byte array extracted: %s", value));
        }

        protected void accept(double[] value) {
            System.out.println(String.format("Double array extracted: %s", value));
        }

        protected void accept(int[] value) {
            System.out.println(String.format("Integer array extracted: %s", value));
        }

        protected void accept(long[] value) {
            System.out.println(String.format("Long array extracted: %s", value));
        }

        protected void accept(MetadataPackage value) {
            System.out.println(String.format("Metadata package value extracted: %s", value));
        }

        protected void accept(MetadataPackage[] value) {
            System.out.println(String.format("Metadata package array extracted: %s", (Object) value));
        }

        protected void accept(UUID value) {
            System.out.println(String.format("Guid value extracted: %s", value));
        }

        protected void accept(PropertyValue[] value) {
            System.out.println(String.format("Property value array extracted: %s", (Object) value));
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
