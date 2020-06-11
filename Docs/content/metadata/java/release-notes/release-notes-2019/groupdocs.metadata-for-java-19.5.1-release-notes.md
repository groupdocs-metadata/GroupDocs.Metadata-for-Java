---
id: groupdocs-metadata-for-java-19-5-1-release-notes
url: metadata/java/groupdocs-metadata-for-java-19-5-1-release-notes
title: GroupDocs.Metadata for Java 19.5.1 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 19.5.1{{< /alert >}}

## Major Features

There are the following features, enhancements and fixes in this release:

*   Fix "Invalid xls format" exception when loading Excel worksheet

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2909 | "Invalid xls format" exception when loading Excel worksheet | Bug |

## Public API and Backward Incompatible Changes

### "Invalid xls format" exception when loading Excel worksheet

[https://forum.groupdocs.com/t/error-occurred-when-loading-xls-file-using-groupdocs-metadata-formats-document-xlsformat/7280/2](https://forum.groupdocs.com/t/error-occurred-when-loading-xls-file-using-groupdocs-metadata-formats-document-xlsformat/7280/2)

The exception occurred because of a problematic Excel file saved in the Microsoft Excel 5.0/95 format which GroupDocs.Metadata was unable to recognize. This release adds support for such files so they can be loaded by the library. Please note that GroupDocs.Metadata automatically updates Excel 5.0/95 workbooks to the Excel 97-2003 format during saving. Both these formats have the same extension (.xls) so regular users won't see any difference between the loaded and saved file.  

##### Public API changes in Java version

None

##### Use cases

Load a Microsoft Excel 5.0/95 workbook

**Java**

```csharp
try (XlsFormat format = new XlsFormat("D:\\input95.xls"))
{
	// Work with the workbook as you normally do with all other Excel files
	// ...
 
	// Please note that it will be saved in the Excel 97-2003 format
	format.save("D:\\output97.xls");
} 
```
