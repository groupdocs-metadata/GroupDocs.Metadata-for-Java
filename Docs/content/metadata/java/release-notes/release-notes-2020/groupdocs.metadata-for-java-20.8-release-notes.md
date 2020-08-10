---
id: groupdocs-metadata-for-java-20-8-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-8-release-notes
title: GroupDocs.Metadata for Java 20.8 Release Notes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.8{{< /alert >}}

## Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement the ability to add/update EXIF metadata properties of arbitrary types using the search API
*   Implement the ability to add/update XMP metadata properties of arbitrary types using the search API
*   "Compression is not supported" exception is thrown when reading BMP
*   Visio Document version is not supported
*   Exception is thrown when trying to access Inspection Package
*   "Already registered Parameter " exception when reading Presentation file
*   Incorrect image size

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-3432 | Implement the ability to add/update EXIF metadata properties of arbitrary types using the search API              | Improvement |
| METADATANET-3433 | Implement the ability to add/update XMP metadata properties of arbitrary types using the search API               | Improvement |
| METADATANET-3275 | "Compression is not supported" exception is thrown when reading BMP                                               | Bug         |
| METADATANET-3289 | Visio Document version is not supported                                                                           | Bug         |
| METADATANET-3291 | Exception is thrown when trying to access Inspection Package                                                      | Bug         |
| METADATANET-3294 | "Already registered Parameter " exception when reading Presentation file                                          | Bug         |
| METADATANET-3469 | Incorrect image size                                                                                              | Bug         |


## Public API and Backward Incompatible Changes

### Implement the ability to add/update EXIF metadata properties of arbitrary types using the search API

Starting from version 20.8 the GroupDocs.Metadata search engine supports adding and updating  EXIF properties of all types (In previous versions only ASCII properties were supported).

##### Public API changes

The [ExifGpsPackage.getTrack](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ExifGpsPackage#getTrack()) method has been marked as obsolete. Please use the [getGpsTrack](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ExifGpsPackage#getGpsTrack()) method instead.

The [ExifGpsPackage.setTrack](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ExifGpsPackage#setTrack(java.lang.String)) method has been marked as obsolete. Please use the [setGpsTrack](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ExifGpsPackage#setGpsTrack(com.groupdocs.metadata.core.TiffRational)) method instead.

##### Use cases

Set an EXIF property having an array type


```java
public class SetExifProperty {
    public static void run() {
        try (Metadata metadata = new Metadata("D:\\input.tiff")) {
            IExif root = (IExif) metadata.getRootPackage();
            // Set the EXIF package if it's missing
            if (root.getExifPackage() == null) {
                root.setExifPackage(new ExifPackage());
            }
            // The latitude (as well as longitude) in EXIF is expressed as three rational values giving the degrees, minutes and seconds respectively
            // We set them as three double values
            double[] latitude = new double[] { 53, 21, 0.50 };
            double[] longitude = new double[] { 6, 15, 58.17 };
            root.getExifPackage().setProperties(new SetExifProperty().new TiffTagSpecification(TiffTagID.GpsLatitude), new PropertyValue(latitude));
            root.getExifPackage().setProperties(new SetExifProperty().new TiffTagSpecification(TiffTagID.GpsLongitude), new PropertyValue(longitude));
            metadata.save("D:\\output.tiff");
        }
         
        // Check the output file
        try (Metadata metadata = new Metadata("D:\\output.tiff")) {
            IExif root = (IExif)metadata.getRootPackage();
            String format = "%s deg %s min %s sec";
            // All the values are converted to human readable rationals
            System.out.println(String.format(format, 
                root.getExifPackage().getGpsPackage().getLatitude()[0],
                root.getExifPackage().getGpsPackage().getLatitude()[1],
                root.getExifPackage().getGpsPackage().getLatitude()[2]));
            System.out.println(String.format(format, 
                root.getExifPackage().getGpsPackage().getLongitude()[0],
                root.getExifPackage().getGpsPackage().getLongitude()[1],
                root.getExifPackage().getGpsPackage().getLongitude()[2]));
        }
    }
     
    private class TiffTagSpecification  extends Specification {
        public TiffTagSpecification(int id) {
            setId(id);
        }
        public final int getId(){ return auto_Id; }
        private void setId(int value){ auto_Id = value; }
        private int auto_Id;
        public boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate instanceof TiffTag && ((TiffTag)candidate).getTagID() == getId();
        }
    }
} 
```

### Implement the ability to add/update XMP metadata properties of arbitrary types using the search API

Starting from version 20.8 the GroupDocs.Metadata search engine supports adding and updating XMP properties of all types (In previous versions only certain scalar types were supported).

##### Public API changes 

None

##### Use cases

Set an XMP property having an array type

```java
try (Metadata metadata = new Metadata("D:\\input.gif")) {
    IXmp root = (IXmp) metadata.getRootPackage();
     
    // add the package if it's missing
    if (root.getXmpPackage() == null) {
        root.setXmpPackage(new XmpPacketWrapper());
    }
    // if there is no such scheme in the XMP package we should create it
    if (root.getXmpPackage().getSchemes().getDublinCore() == null) {
        root.getXmpPackage().getSchemes().setDublinCore(new XmpDublinCorePackage());
    }
     
    String[] creators = new String[] { "creator1", "creator2", "creator3" };
    Date date = new Date();
    root.getXmpPackage().setProperties(new ContainsTagSpecification(Tags.getPerson().getCreator()), new PropertyValue(creators));
    root.getXmpPackage().setProperties(new WithNameSpecification("dc:date"), new PropertyValue(date));
    metadata.save("D:\\output.gif");
}
 
// Check the output file
try (Metadata metadata = new Metadata("D:\\output.gif")) {
    IXmp root = (IXmp) metadata.getRootPackage();
     
    for (String creator : root.getXmpPackage().getSchemes().getDublinCore().getCreators()) {
        System.out.println(creator);
    }
     
    for (Date date : root.getXmpPackage().getSchemes().getDublinCore().getDates()) {
        System.out.println(date);
    }
} 
```
 

Set an XMP-specific value


```java
try (Metadata metadata = new Metadata("D:\\input.gif")) {
    IXmp root = (IXmp) metadata.getRootPackage();
     
    // add the package if it's missing
    if (root.getXmpPackage() == null) {
        root.setXmpPackage(new XmpPacketWrapper());
    }
    // if there is no such scheme in the XMP package we should create it
    if (root.getXmpPackage().getSchemes().getDublinCore() == null) {
        root.getXmpPackage().getSchemes().setDublinCore(new XmpDublinCorePackage());
    }
    // Set a lang alt value
    XmpLangAlt rights = new XmpLangAlt("Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.");
    root.getXmpPackage().setProperties(new ContainsTagSpecification(Tags.getLegal().getCopyright()), rights);
    metadata.save("D:\\output.gif");
}
 
// Check the output file
try (Metadata metadata = new Metadata("D:\\output.gif")) {
    IXmp root = (IXmp) metadata.getRootPackage();
     
    for (String right : root.getXmpPackage().getSchemes().getDublinCore().getRights().toPlatformArray(String.class)) {
        System.out.println(right);
    }
}
```
