---
id: migration-notes
url: metadata/java/migration-notes
title: Migration Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
# Why To Migrate?

Here are the key reasons to use the new API provided by GroupDocs.Metadata for Java starting from version 20.2:

*   The* Metadata* class is introduced as a **single entry point** to manage metadata in files of all supported formats.
*   Extracting and updating metadata was unified for all supported formats.
*   The product architecture was redesigned from scratch in order to simplify most common operations with metadata properties.
*   Getting document information and preview generation procedures were simplified.

# How To Migrate?

Here is a brief comparison of how to manage metadata using the old and new API.


### Loading Files

#### Any Supported Format

The following examples show how to load a file of any supported format.

**Old API**

```csharp
try (FormatBase format = FormatFactory.recognizeFormat("D:\\input.doc")) {
	// ...
}
```

**New API**

```csharp
try (Metadata metadata = new Metadata("D:\\input.doc")) {
	// ...
}
```

#### Some Specific Format

The code samples below demonstrate how to load a file of a specific format.

**Old API**

```csharp
try (XlsFormat xlsFormat = new XlsFormat("D:\\input.xls")) {
	// ...
}
```

**New API**

```csharp
LoadOptions loadOptions = new LoadOptions(FileFormat.Spreadsheet);
try (Metadata metadata = new Metadata(Constants.InputXls, loadOptions)) {
	SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
	// ...
}
```

### Working with Metadata using Regular Expressions

#### Finding Metadata using Regular Expressions

The following code snippets retrieve metadata from a file using a regular expression.

**Old API**

```csharp
Pattern pattern = Pattern.compile("author|company", Pattern.CASE_INSENSITIVE);
MetadataPropertyCollection properties = SearchFacade.scanDocument("D:\\input.docx", pattern);
for (int i = 0; i < properties.getCount(); i++)
{
    System.out.println(properties.readByIndex(i));
}
```

**New API**

```csharp
public class FindPropertiesByRegex {
    public static void run() {
        Pattern pattern = Pattern.compile("author|company", Pattern.CASE_INSENSITIVE);

        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            // This method searches for properties across all metadata packages and works with all supported formats
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FindPropertiesByRegex().new RegexSpecification(pattern));

            for (MetadataProperty property : properties) {
                System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
            }
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

#### Replacing Metadata using Regular Expressions

The following code snippets show how to replace metadata properties using a regular expression.

**Old API**

```csharp
Pattern pattern = Pattern.compile("^author|company$", Pattern.CASE_INSENSITIVE);
String replaceValue = "Aspose";

SearchFacade.replaceInDocument("D:\\input.docx", pattern, replaceValue, "D:\\output.docx");
```

**New API**

```csharp
public class UpdatePropertiesByRegex {
    public static void run() {
        Pattern pattern = Pattern.compile("^author|company$", Pattern.CASE_INSENSITIVE);
        PropertyValue replaceValue = new PropertyValue("Aspose");

        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            // This method updates writable properties across all metadata packages and works with all supported formats
            metadata.updateProperties(new UpdatePropertiesByRegex().new RegexSpecification(pattern), replaceValue);

            metadata.save(Constants.OutputDocx);
        }
    }

    private class RegexSpecification extends Specification {
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

### Exporting Metadata

#### Export Metadata Properties to CSV

The following code snippets show how to export metadata properties to a CSV file.

**Old API**

```csharp
try (FileOutputStream stream = new FileOutputStream("D:\\metadata.csv")) {

	byte[] content = ExportFacade.exportToCsv("D:\\input.eml");
	stream.write(content);
}
```

**New API**

```csharp
try (Metadata metadata = new Metadata(Constants.InputEml)) {
	// We use a predicate that extracts all metadata properties
	IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());
	String delimiter = ";";
	StringBuilder builder = new StringBuilder();
	builder.append(String.format("Name%sValue", delimiter));
	builder.append("\n");
	for (MetadataProperty property : properties) {
		builder.append(String.format("\"%s\"%s\"%s\"", property.getName(), delimiter, formatValue(property.getValue())));
		builder.append("\n");
	}
	try (PrintWriter out = new PrintWriter(Constants.OutputCsv)) {
		out.println(builder.toString());
	}
}
```

{{< alert style="info" >}}The implementation of the FormatValue method used in the code sample above can be different depending on your task so we just omitted it here. Please see the full code of the method in the sample project on GitHub.{{< /alert >}}

### Using the Replace API

#### Update Values with IReplaceHandler

The code samples below show how to update metadata properties using a custom filter.

**Old API (Implementation of IReplaceHandler)**

```csharp
public class AuthorReplaceHandler implements IReplaceHandler<MetadataProperty>
{
	public AuthorReplaceHandler(String outputPath)
	{
		this.outputPath = outputPath;
	}

	public String outputPath;

	@Override
	public String getOutputPath() {
		return outputPath;
	}

	public boolean handle(MetadataProperty property)
	{
		// if property name is 'author'
		if ("author".equalsIgnoreCase(property.getName()))
		{
			// update property value
			property.setValue(new PropertyValue("Jack London"));
			// and mark property as updated
			return true;
		}
		// ignore all other properties
		return false;
	}
}
```

**Old API (Usage of AuthorReplaceHandler)**

```csharp
// initialize custom handler, send output path using constructor
IReplaceHandler<MetadataProperty> replaceHandler = new AuthorReplaceHandler("D:\\output.docx");
// replace author
int affectedPropertiesCount = SearchFacade.replaceInDocument("D:\\intput.docx", replaceHandler);
```

In the new API there is no need to use the IReplaceHandler interface since you have full control over property filters using the GrooupDocs.Metadata search engine.

**New API**

```csharp
public class UpdatePropertyValue {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            int affected = metadata.updateProperties(new UpdatePropertyValue().new CustomNameComparerSpecification("author"), new PropertyValue("Jack London"));

            System.out.println(affected);

            metadata.save(Constants.OutputDocx);
        }
    }

    private class CustomNameComparerSpecification extends Specification {

        private String name;

        public CustomNameComparerSpecification(String name) {
            this.name = name;
        }

        @Override
        public boolean isSatisfiedBy(MetadataProperty metadataProperty) {
            return metadataProperty.getName().equalsIgnoreCase(name);
        }
    }
}
```

### Extracting a Specific Metadata Package

#### Extract a Metadata Package of a Specific Type

The code samples below demonstrate how to fetch a metadata package with a specific type.

**Old API**

```csharp
DublinCoreMetadata dublinCoreMetadata = (DublinCoreMetadata) MetadataUtility.extractSpecificMetadata("D:\\input.docx", MetadataType.DublinCore);

if (dublinCoreMetadata != null)
{
    System.out.println(dublinCoreMetadata.getCreator());
    System.out.println(dublinCoreMetadata.getFormat());
    System.out.println(dublinCoreMetadata.getSubject());
}
```

**New API**

```csharp
public class ExtractPackageUsingCommonApi {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new ExtractPackageUsingCommonApi().new AssignableFromSpecification(DublinCorePackage.class));
            MetadataProperty property = properties.getCount() > 0 ? properties.get_Item(0) : null;

            if (property != null) {
                DublinCorePackage dcPackage = property.getValue().toClass(DublinCorePackage.class);

                System.out.println(dcPackage.getFormat());
                System.out.println(dcPackage.getContributor());
                System.out.println(dcPackage.getCoverage());
                System.out.println(dcPackage.getCreator());
                System.out.println(dcPackage.getSource());
                System.out.println(dcPackage.getDescription());

                // ...
            }
        }
    }

    private class AssignableFromSpecification extends Specification {

        private Class<?> clazz;

        public AssignableFromSpecification(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public boolean isSatisfiedBy(MetadataProperty metadataProperty) {
            return metadataProperty.getValue().getRawValue() != null && clazz.isAssignableFrom(metadataProperty.getValue().getRawValue().getClass());
        }
    }
}
```
