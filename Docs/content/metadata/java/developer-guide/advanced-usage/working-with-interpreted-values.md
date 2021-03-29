---
id: working-with-interpreted-values
url: metadata/java/working-with-interpreted-values
title: Working with interpreted values
weight: 8
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
Sometimes it's not really obvious what a particular metadata property is supposed to mean. A good example of such vague property is a numeric flag or enumeration. For example, here is the description of the EXIF ExposureProgram tag taken from the official EXIF specification:

{{< alert style="info" >}}
The class of the program used by the camera to set exposure when the picture is taken. The tag values are as follows.

0 = Not defined

1 = Manual

2 = Normal program

3 = Aperture priority

4 = Shutter priority

5 = Creative program

6 = Action program

7 = Portrait mode

8 = Landscape mode

{{< /alert >}}

As you can see, all modes are represented by numeric values. If you are not familiar with the specification, you will get a hard time converting these bare numbers to something meaningful. This is where interpreted values come into play. They provide a user-friendly description of the original property value. The code snippet below demonstrates how to extract the ExposureProgram property and display its original value and interpreted value.

```java
try (Metadata metadata = new Metadata("D:\\input.heic"))
{
    IExif root = (IExif)metadata.getRootPackage();
    if (root.getExifPackage() != null)
    {
        TiffShortTag property = (TiffShortTag)root.getExifPackage().getExifIfdPackage().getByTiffTagID(TiffTagID.ExposureProgram);
        if (property != null)
        {
            System.out.println(property.getTagValue()[0]); // 2
            System.out.println(property.getInterpretedValue()); // Normal program
        }
    }
}
```

From release to release, we add interpreters to metadata properties extracted from various formats. To get a full list of properties having interpreted values for a particular file please use the below example:

**advanced_usage.WorkingWithInterpretedValues**

```java
public class WorkingWithInterpretedValues {
     public static void run() {
        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles()) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());
                     
                    IReadOnlyList<MetadataProperty> properties = metadata.findProperties(
                            new WorkingWithInterpretedValues().new InterpretedValueIsNotNullSpecification());
                    for (MetadataProperty property : properties) {
                            System.out.println(property.getName());
                            System.out.println(property.getValue().getRawValue());
                            System.out.println(property.getInterpretedValue().getRawValue());
                    }
                }
            }
        }
    }
      
    private class InterpretedValueIsNotNullSpecification extends Specification {
        public boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate.getInterpretedValue() != null;
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
