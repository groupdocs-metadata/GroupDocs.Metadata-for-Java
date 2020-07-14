---
id: working-with-xmp-metadata
url: metadata/java/working-with-xmp-metadata
title: Working with XMP metadata
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## What is XMP?

The Extensible Metadata Platform (XMP) is an XML-based ISO metadata standard, originally created by Adobe Systems Inc. It defines a data structure, serialization model and basic metadata properties intended to form a unified metadata package that can be embedded into different media formats. The defined XMP data model can be used to store any set of metadata properties. These can be simple name/value pairs, structured values or lists of values. The data can be nested as well.

{{< alert style="info" >}}Please find more information on the XMP standard at https://en.wikipedia.org/wiki/Extensible_Metadata_Platform{{< /alert >}}

## Reading XMP properties

To access XMP metadata in a file of any supported format, GroupDocs.Metadata provides the [IXmp.getXmpPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IXmp#getXmpPackage()) method. The following are the steps to read XMP metadata:

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains XMP metadata
2.  Extract the XMP metadata package using the [IXmp.getXmpPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IXmp#getXmpPackage()) method

The following code snippet gets XMP properties of a PNG image and displays them on the screen. 

**advanced\_usage.working\_with\_metadata\_standards.xmp.ReadXmpProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.PngWithXmp)) {
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

Here is a full list of supported XMP schemes:

*   [XmpBasicJobTicketPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpBasicJobTicketPackage)
*   [XmpBasicPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpBasicPackage)
*   [XmpCameraRawPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpCameraRawPackage)
*   [XmpDublinCorePackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpDublinCorePackage)
*   [XmpDynamicMediaPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpDynamicMediaPackage)
*   [XmpIptcCorePackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpIptcCorePackage)
*   [XmpIptcExtensionPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpIptcExtensionPackage)
*   [XmpIptcIimPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpIptcIimPackage)
*   [XmpMediaManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpMediaManagementPackage)
*   [XmpPagedTextPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpPagedTextPackage)
*   [XmpPdfPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpPdfPackage)
*   [XmpPhotoshopPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpPhotoshopPackage)
*   [XmpRightsManagementPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpRightsManagementPackage)

{{< alert style="info" >}}GroupDocs.Metadata also provides an API allowing users to work with fully custom XMP schemes/packages. Please refer to this code snippet to learn more.{{< /alert >}}

## Updating XMP properties

The GroupDocs.Metadata API facilitates the user to update XMP metadata in a convenient way - using the [XmpPacketWrapper](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/XmpPacketWrapper) class methods. Follow the below steps to update XMP metadata in a file of any supported format.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains XMP metadata
2.  Extract the XMP metadata package using the [IXmp.getXmpPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IXmp#getXmpPackage()) method
3.  Assign values to desired XMP properties
4.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

**advanced\_usage.working\_with\_metadata\_standards.xmp.UpdateXmpProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.GifWithXmp)) {
	IXmp root = (IXmp) metadata.getRootPackage();
	
	if (root.getXmpPackage() != null) {
		// if there is no such scheme in the XMP package we should create it
		if (root.getXmpPackage().getSchemes().getDublinCore() == null) {
			root.getXmpPackage().getSchemes().setDublinCore(new XmpDublinCorePackage());
		}

		root.getXmpPackage().getSchemes().getDublinCore().setFormat("image/gif");
		root.getXmpPackage().getSchemes().getDublinCore().setRights("Copyright (C) 2011-2020 GroupDocs. All Rights Reserved");
		root.getXmpPackage().getSchemes().getDublinCore().setSubject("test");

		if (root.getXmpPackage().getSchemes().getCameraRaw() == null) {
			root.getXmpPackage().getSchemes().setCameraRaw(new XmpCameraRawPackage());
		}
		
		root.getXmpPackage().getSchemes().getCameraRaw().setShadows(50);
		root.getXmpPackage().getSchemes().getCameraRaw().setAutoBrightness(true);
		root.getXmpPackage().getSchemes().getCameraRaw().setAutoExposure(true);
		root.getXmpPackage().getSchemes().getCameraRaw().setCameraProfile("test");
		root.getXmpPackage().getSchemes().getCameraRaw().setExposure(0.0001);

		// If you don't want to keep the old values just replace the whole scheme
		root.getXmpPackage().getSchemes().setXmpBasic(new XmpBasicPackage());
		root.getXmpPackage().getSchemes().getXmpBasic().setCreateDate(new Date());
		root.getXmpPackage().getSchemes().getXmpBasic().setBaseUrl("https://groupdocs.com");
		root.getXmpPackage().getSchemes().getXmpBasic().setRating(5);
		root.getXmpPackage().getSchemes().setBasicJobTicket(new XmpBasicJobTicketPackage());

		// Set a complex type property
		XmpJob job = new XmpJob();
		job.setID("1");
		job.setName("test job");
		job.setUrl("https://groupdocs.com");
		root.getXmpPackage().getSchemes().getBasicJobTicket().setJobs(new XmpJob[]{job});

		// ...

		metadata.save(Constants.OutputGif);
	}
}
```

## Adding a custom XMP package

The GroupDocs.Metadata API provides access to a number of commonly used XMP schemes. But it also allows you to create fully custom XMP packages containing user-defined properties. The example below demonstrates how to create and add a custom XMP package to a file.

**advanced\_usage.working\_with\_metadata\_standards.xmp.AddCustomXmpPackage**

```csharp
try (Metadata metadata = new Metadata(Constants.InputJpeg)) {

	IXmp root = (IXmp) metadata.getRootPackage();
	XmpPacketWrapper packet = new XmpPacketWrapper();

	XmpPackage custom = new XmpPackage("gd", "https://groupdocs.com");
	custom.set("gd:Copyright", "Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.");
	custom.set("gd:CreationDate", new Date());
	custom.set("gd:Company", XmpArray.from(new String[]{"Aspose", "GroupDocs"}, XmpArrayType.Ordered));

	packet.addPackage(custom);
	root.setXmpPackage(packet);
	metadata.save(Constants.OutputJpeg);
}
```

## Removing XMP metadata

To remove the XMP package from a file just pass null to the [IXmp.setXmpPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IXmp#setXmpPackage(com.groupdocs.metadata.core.XmpPacketWrapper)) method as a parameter. The code sample below shows how to remove XMP metadata from a file.

**advanced\_usage.working\_with\_metadata\_standards.xmp.AddCustomXmpPackage**

```csharp
try (Metadata metadata = new Metadata(Constants.JpegWithXmp)) {
	IXmp root = (IXmp) metadata.getRootPackage();
	root.setXmpPackage(null);
	metadata.save(Constants.OutputJpeg);
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
