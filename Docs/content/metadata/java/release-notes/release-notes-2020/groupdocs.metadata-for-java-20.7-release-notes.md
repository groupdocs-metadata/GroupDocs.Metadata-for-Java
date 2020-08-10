---
id: groupdocs-metadata-for-java-20-7-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-7-release-notes
title: GroupDocs.Metadata for Java 20.7 Release Notes
weight: 7
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.7{{< /alert >}}

## Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement the ability to work with EXIF metadata in JPEG2000 images
*   Add support for the HEIF/HEIC format
*   Implement the ability to extract metadata from encrypted MS Project files
*   Implement the ability to manage custom properties in Project files. Add support for additional built-in properties

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2845 | Implement the ability to work with EXIF metadata in JPEG2000 images	                                           | New Feature |
| METADATANET-3387 | Add support for the HEIF/HEIC format	                                                                           | New Feature |
| METADATANET-2843 | Implement the ability to extract metadata from encrypted MS Project files	                                       | Improvement |
| METADATANET-1479 | Implement the ability to manage custom properties in Project files. Add support for additional built-in properties| Improvement |


## Public API and Backward Incompatible Changes

### Implement the ability to work with EXIF metadata in JPEG2000 images 

This new feature allows the user to add, update and remove EXIF metadata
packages in JPEG2000 images.

##### Public API changes

The [Jpeg2000RootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/Jpeg2000RootPackage) class
now implements
the [IExif](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif) interface

The [getExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/Jpeg2000RootPackage#getExifPackage()) method
has been added to
the [Jpeg2000RootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/Jpeg2000RootPackage) class

The [setExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/JpegRootPackage#setExifPackage(com.groupdocs.metadata.core.ExifPackage)) method
has been added to
the [Jpeg2000RootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/Jpeg2000RootPackage) class

##### Use cases

Read EXIF metadata properties from a JPEG2000 image


```java
try (Metadata metadata = new Metadata("D:\\exif.jp2")) {
    IExif root = (IExif) metadata.getRootPackage();

    if (root.getExifPackage() != null) {
        System.out.println(root.getExifPackage().getArtist());
        System.out.println(root.getExifPackage().getCopyright());
        System.out.println(root.getExifPackage().getImageDescription());
        System.out.println(root.getExifPackage().getMake());
        System.out.println(root.getExifPackage().getModel());
        System.out.println(root.getExifPackage().getSoftware());
        System.out.println(root.getExifPackage().getImageWidth());
        System.out.println(root.getExifPackage().getImageLength());

        // ...

        System.out.println(root.getExifPackage().getExifIfdPackage().getBodySerialNumber());
        System.out.println(root.getExifPackage().getExifIfdPackage().getCameraOwnerName());
        System.out.println(root.getExifPackage().getExifIfdPackage().getUserComment());

        // ...

        System.out.println(root.getExifPackage().getGpsPackage().getAltitude());
        System.out.println(root.getExifPackage().getGpsPackage().getLatitudeRef());
        System.out.println(root.getExifPackage().getGpsPackage().getLongitudeRef());

        // ...
    }
}
```

### Add support for the HEIF/HEIC format

This new feature allows the user to work with HEIF/HEIC images.

##### Public API changes 

The [HeifRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/HeifRootPackage) class
has been added to
the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-frame) package

The
[Heif](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/FileFormat#Heif) public
static field has been added to
the [FileFormat](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/FileFormat) class

##### Use cases

Read XMP metadata properties from a HEIC image


```java
try (Metadata metadata = new Metadata("D:\\xmp.heic")) {

    IXmp root = (IXmp) metadata.getRootPackage();

    if (root.getXmpPackage() != null) {
        if (root.getXmpPackage().getSchemes().getXmpBasic() != null) {
            System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getCreatorTool());
            System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getCreateDate());
            System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getModifyDate());
            System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getLabel());
            System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getNickname());

            // ...
        }

        if (root.getXmpPackage().getSchemes().getDublinCore() != null) {
            System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getFormat());
            System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getCoverage());
            System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getIdentifier());
            System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getSource());

            // ...
        }

        if (root.getXmpPackage().getSchemes().getPhotoshop() != null) {
            System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getColorMode());
            System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getIccProfile());
            System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getCountry());
            System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getCity());
            System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getDateCreated());

            // ...
        }

        // ...
    }
}
```
 

Read EXIF Tags from a HEIC image


```java
try (Metadata metadata = new Metadata("D:\\exif.heic")) {
    IExif root = (IExif) metadata.getRootPackage();
    if (root.getExifPackage() != null) {

        String pattern = "%s = %s";
        for (TiffTag tag : root.getExifPackage().toList()) {
            System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
        }

        for (TiffTag tag : root.getExifPackage().getExifIfdPackage().toList()) {
            System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
        }

        for (TiffTag tag : root.getExifPackage().getGpsPackage().toList()) {
            System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
        }
    }
} 
```

 

### Implement the ability to extract metadata from encrypted MS Project files 

This improvement allows the user to read password-protected MS Project
files.

##### Public API changes

None

##### Use cases

Load a password-protected document


```java
// Specify the password
LoadOptions loadOptions = new LoadOptions();
loadOptions.setPassword("123");

// Constants.ProtectedDocx is an absolute or relative path to your document. Ex: @"C:\Docs\source.docx"
try (Metadata metadata = new Metadata("D:\\test.mpp", loadOptions)) {
    // Extract, edit or remove metadata here
}
```

Please note, the ability to save password-protected MS Project documents
is not implemented yet

### Implement the ability to manage custom properties in Project files. Add support for additional built-in properties {#GroupDocs.MetadataforJava20.7-ImplementtheabilitytomanagecustompropertiesinProjectfiles.Addsupportforadditionalbuilt-inproperties}

This improvement extends the list of metadata properties that are
available for reading/updating in MS Project documents.

##### Public API changes

The
[getManager](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#getManager()) method
has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[setManager](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#setManager(java.lang.String)) method
has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[getLastSaved](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#getLastSaved())
method has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[setLastSaved](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#setLastSaved(java.util.Date)) method has
been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[getSaveVersion](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#getSaveVersion())
method has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[getLastPrinted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#getLastPrinted())
method has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[setLastPrinted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#setLastPrinted(java.util.Date)) method has
been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[set(String,String)](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#set(java.lang.String,%20java.lang.String)) method
has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[set(String,double)](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#set(java.lang.String,%20double)) method
has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[set(String,boolean)](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#set(java.lang.String,%20boolean)) method
has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[set(String,Date)](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#set(java.lang.String,%20java.util.Date)) method
has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

The
[set(String,int)](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage#set(java.lang.String,%20int)) method
has been added to
the [ProjectManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ProjectManagementPackage) class

##### Use cases

Read project properties

```java
try (Metadata metadata = new Metadata("D:\\test.mpp")) {
    ProjectManagementRootPackage root = metadata.getRootPackageGeneric();
    System.out.println(root.getDocumentProperties().getManager());
    System.out.println(root.getDocumentProperties().getLastSaved());
    System.out.println(root.getDocumentProperties().getSaveVersion());
    System.out.println(root.getDocumentProperties().getLastPrinted());

    // ...
}
```

Read custom metadata properties

```java
try (Metadata metadata = new Metadata("D:\\test.mpp")) {
    ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

    IReadOnlyList<MetadataProperty> customProperties = root.getDocumentProperties().findProperties(new ContainsTagSpecification(Tags.getDocument().getBuiltIn()).not());

    for (MetadataProperty property : customProperties) {
        System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
    }
}
```

Read even more metadata properties iterating the package as a collection

```java
try (Metadata metadata = new Metadata("D:\\test.mpp")) {

    ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

    for (MetadataProperty property : root.getDocumentProperties()) {
        System.out.println(String.format("%s = %s", property.getName(), property.getValue()));
    }
}
```

Update metadata properties


```java
try (Metadata metadata = new Metadata("D:\\input.mpp")) {

    ProjectManagementRootPackage root = metadata.getRootPackageGeneric();

    root.getDocumentProperties().set("customProperty1", "some value");
    root.getDocumentProperties().set("customProperty2", 7);
    root.getDocumentProperties().set("customProperty3", true);

    metadata.save("D:\\output.mpp");
}
```