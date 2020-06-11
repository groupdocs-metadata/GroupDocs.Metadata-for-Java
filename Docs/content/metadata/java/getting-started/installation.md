---
id: installation
url: metadata/java/installation
title: Installation
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Development environment

### Operating systems

**GroupDocs.Metadata for Java** can be executed on any Operating System with Java JDK installed.

*   Windows Desktops and Servers
*   Linux
*   Mac OS

### Supported runtime

**GroupDocs.Metadata for Java** supports Java run-time version 7 (1.7) and above.

### Development environments

*   NetBeans
*   IntelliJ IDEA
*   Eclipse

## Installation from GroupDocs artifactory using Maven

GroupDocs hosts all Java APIs on [GroupDocs Artifactory](https://repository.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo). You can easily use [GroupDocs.Metadata for Java](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-metadata) API directly in your Maven projects with simple configurations.

### Specify GroupDocs repository configuration

First, you need to specify GroupDocs repository configuration/location in your Maven `pom.xml` as follows:

```csharp
<repositories>
	<repository>
		<id>GroupDocsJavaAPI</id>
		<name>GroupDocs Java API</name>
		<url>http://repository.groupdocs.com/repo/</url>
	</repository>
</repositories>
```

### Define GroupDocs.Metadata for Java API dependency

Then define GroupDocs.Metadata for Java API dependency in your pom.xml as follows:

```csharp
<dependencies>
    <dependency>
        <groupId>com.groupdocs</groupId>
        <artifactId>groupdocs-metadata</artifactId>
        <version>20.2</version> 
    </dependency>
</dependencies>
```

After performing above-mentioned steps, the GroupDocs.Metadata for Java dependency will finally be added to your Maven project.
