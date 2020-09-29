---
id: groupdocs-metadata-for-java-20-10-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-10-release-notes
title: GroupDocs.Metadata for Java 20.10 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.10{{< /alert >}}

## Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement the ability to work with repeatable IPTC properties
*   Implement the ability to generate image previews for EPUB files
*   Implement the ability to generate image previews for supported CAD formats
*   Implement the ability to preview EML and MSG files
*   Exception: Could not read the PSD file

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2639 | Implement the ability to work with repeatable IPTC properties                   | Improvement |
| METADATANET-3547 | Implement the ability to generate image previews for EPUB files                 | Improvement |
| METADATANET-3546 | Implement the ability to generate image previews for supported CAD formats      | Improvement |
| METADATANET-3553 | Implement the ability to preview EML and MSG files                              | Improvement |
| METADATANET-3280 | Exception: Could not read the PSD file                                          | Bug         |




## Public API and Backward Incompatible Changes

### Implement the ability to work with repeatable IPTC properties

This improvement allows the user to add multiple datasets with the same number to an IPTC record

##### Public API changes 

The [getByLines](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#getByLines()) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [setByLines](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#setByLines(java.lang.String[])) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [getByLineTitles](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#getByLineTitles()) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [setByLineTitles](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#setByLineTitles(java.lang.String[])) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [getContentLocationCodes](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#getContentLocationCodes()) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [setContentLocationCodes](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#setContentLocationCodes(java.lang.String[])) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [getContentLocationNames](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#getContentLocationNames()) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [setContentLocationNames](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#setContentLocationNames(java.lang.String[])) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [getReferenceDates](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#getReferenceDates()) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [getContacts](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#getContacts()) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [setContacts](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#setContacts(java.lang.String[])) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [getAllKeywords](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#getAllKeywords()) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [setAllKeywords](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord#setAllKeywords(java.lang.String[])) method has been added to the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) class

The [getDestinations](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord#getDestinations()) method has been added to the [IptcEnvelopeRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord) class

The [setDestinations](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord#setDestinations(java.lang.String[])) method has been added to the [IptcEnvelopeRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord) class

The [getProductIds](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord#getProductIds()) method has been added to the [IptcEnvelopeRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord) class

The [setProductIds](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord#setProductIds(java.lang.String[])) method has been added to the [IptcEnvelopeRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord) class

The [add](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcRecordSet#add(com.groupdocs.metadata.core.IptcDataSet)) method has been added to the [IptcRecordSet](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcRecordSet) class

##### Use cases 

Read repeatable IPTC datasets

```java
try (Metadata metadata = new Metadata("D:\\input.psd")) {
    IIptc root = (IIptc) metadata.getRootPackage();
    if (root.getIptcPackage() != null) {
        for (IptcDataSet dataSet : root.getIptcPackage().toDataSetList()) {
             
            // Check if the dataset is repeatable
            if (dataSet.getValue().getType() == MetadataPropertyType.PropertyValueArray) {
                System.out.println(dataSet.getRecordNumber());
                System.out.println(dataSet.getDataSetNumber());
                System.out.println(dataSet.getAlternativeName());
                for (PropertyValue value : dataSet.getValue().toArray(PropertyValue.class)) {
                        System.out.print(String.format("%s, ", value.getRawValue()));
                }
                System.out.println();
            }
        }
    }
} 
```

Add repeatable IPTC datasets

```java
try (Metadata metadata = new Metadata("D:\\input.psd")) {
    IIptc root = (IIptc)metadata.getRootPackage();
     
    // Set the IPTC package if it's missing
    if (root.getIptcPackage() == null) {
        root.setIptcPackage(new IptcRecordSet());
    }
 
    root.getIptcPackage().add(new IptcDataSet((byte)IptcRecordType.ApplicationRecord, (byte)IptcApplicationRecordDataSet.Keywords, "keyword 1"));
    root.getIptcPackage().add(new IptcDataSet((byte)IptcRecordType.ApplicationRecord, (byte)IptcApplicationRecordDataSet.Keywords, "keyword 2"));
    root.getIptcPackage().add(new IptcDataSet((byte)IptcRecordType.ApplicationRecord, (byte)IptcApplicationRecordDataSet.Keywords, "keyword 3"));
 
    metadata.save("D:\\output.psd");
}
 
// Check the output file
try (Metadata metadata = new Metadata("D:\\output.psd")) {
    IIptc root = (IIptc)metadata.getRootPackage();
    MetadataProperty keywordsProperty = root.getIptcPackage().getApplicationRecord().get_Item((byte)IptcApplicationRecordDataSet.Keywords);
    for (PropertyValue value : keywordsProperty.getValue().toArray(PropertyValue.class)) {
        System.out.println(value);
    }
} 
```

### Implement the ability to generate image previews for EPUB files

This improvement allows the user to generate image previews for EPUB files

##### Public API changes 

None

##### Use cases 

[Generate document preview]({{< ref "metadata/java/developer-guide/basic-usage/generate-document-preview.md" >}})

### Implement the ability to generate image previews for supported CAD formats

This improvement allows the user to generate image previews for DWG and DXF files

##### Public API changes 

None

##### Use cases 

[Generate document preview]({{< ref "metadata/java/developer-guide/basic-usage/generate-document-preview.md" >}})

### Implement the ability to preview EML and MSG files

This improvement allows the user to generate image previews for EML and MSG files

##### Public API changes 

None

##### Use cases 

[Generate document preview]({{< ref "metadata/java/developer-guide/basic-usage/generate-document-preview.md" >}})