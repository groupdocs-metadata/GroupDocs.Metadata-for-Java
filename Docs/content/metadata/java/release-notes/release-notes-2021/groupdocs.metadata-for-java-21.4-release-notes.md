---
id: groupdocs-metadata-for-java-21-4-release-notes
url: metadata/java/groupdocs-metadata-for-java-21-4-release-notes
title: GroupDocs.Metadata for Java 21.4 Release Notes
weight: 10
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 21.4{{< /alert >}}

## Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement metadata property interpreters
*   Implement the ability to edit email fields
*	Image export failed.

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-3752 | Implement metadata property interpreters                                                | New Feature         |
| METADATANET-3758 | Implement the ability to edit email fields                                            	 | Improvement         |
| METADATANET-3751 | Image export failed                              	                                   	 | Bug                 |



## Public API and Backward Incompatible Changes

### Implement metadata property interpreters

This new feature allows the user to get a user-friendly interpretation of a metadata property value. Please refer to [this article]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-interpreted-values.md" >}}) for more information.

##### Public API changes

The [ValueInterpreter](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ValueInterpreter) class has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-summary) package

The [IEnumValueInterpreter](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IEnumValueInterpreter) interface has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-summary) package

The [getInterpretedValue](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataProperty#getInterpretedValue()) method has been added to the [MetadataProperty](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataProperty) class

The [getDescriptor](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataProperty#getDescriptor()) method has been added to the [MetadataProperty](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataProperty) class

The [getInterpreter](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PropertyDescriptor#getInterpreter()) method has been added to the [PropertyDescriptor](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PropertyDescriptor) class

##### Use cases 

Obtain a full list of properties that provide an interpreted value

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
        public /*override*/ boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate.getInterpretedValue() != null;
        }
    }
}
```

### Implement the ability to edit email fields

This improvement allows the user to update some common email fields.

##### Public API changes

The [setSubject](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage#setSubject(java.lang.String)) method has been added to the [EmailPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage) class

The [setRecipients](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage#setRecipients(java.lang.String[])) method has been added to the [EmailPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage) class

The [setCarbonCopyRecipients](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage#setCarbonCopyRecipients(java.lang.String[])) method has been added to the [EmailPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage) class

The [setBlindCarbonCopyRecipients](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage#setBlindCarbonCopyRecipients(java.lang.String[])) method has been added to the [EmailPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailPackage) class

##### Use cases 

Update the email subject and recipients

```java
try (Metadata metadata = new Metadata(Constants.InputEml)) {
    EmailRootPackage root = metadata.getRootPackageGeneric();
    root.getEmailPackage().setRecipients(new String[] { "sample@aspose.com" });
    root.getEmailPackage().setCarbonCopyRecipients(new String[] { "sample@groupdocs.com" });
    root.getEmailPackage().setSubject("RE: test subject");
    metadata.save(Constants.OutputEml);
}
```

### Other API changes

The [getKnowPropertyDescriptors](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataPackage#getKnowPropertyDescriptors()) method has been marked as deprecated. Please use the [getPropertyDescriptors](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MetadataPackage#getPropertyDescriptors()) method instead.
