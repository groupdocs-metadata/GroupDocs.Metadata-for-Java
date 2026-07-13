# GroupDocs.Metadata for Java — AGENTS.md

> Instructions for AI agents working with **Java** examples in this repository.

GroupDocs.Metadata for Java lets applications read, search, edit, and remove metadata — including EXIF, XMP, IPTC, Office properties, PDF info, and ID3 — from **110+** document, image, audio, video, archive, font, CAD, GIS, and ebook formats, without Microsoft Office or Adobe dependencies.

**Supported formats:** **110+** file formats — authoritative table: [https://docs.groupdocs.com/metadata/java/supported-document-formats/](https://docs.groupdocs.com/metadata/java/supported-document-formats/)

**Human overview:** see [README.md](README.md) in this repository.

## Install

Add the dependency via Maven (coordinates from the [Java release hub](https://releases.groupdocs.com/metadata/java/)):

```xml
<dependency>
  <groupId>com.groupdocs</groupId>
  <artifactId>groupdocs-metadata</artifactId>
  <version>26.1</version>
</dependency>
```

Use the [Artifact Repository](https://repository.groupdocs.com/) repository URL in `pom.xml` / `settings.xml` as documented on the release hub.

Package / release hub: [https://releases.groupdocs.com/metadata/java/](https://releases.groupdocs.com/metadata/java/)

## Resources

| Resource | URL |
|---|---|
| Documentation | [https://docs.groupdocs.com/metadata/java/](https://docs.groupdocs.com/metadata/java/) |
| API reference | [https://reference.groupdocs.com/metadata/java/](https://reference.groupdocs.com/metadata/java/) |
| Code examples (this repo) | [https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java) |
| Release notes | [https://releases.groupdocs.com/metadata/java/](https://releases.groupdocs.com/metadata/java/) |
| Package (Maven) | [https://releases.groupdocs.com/java/repo/com/groupdocs/groupdocs-metadata/](https://releases.groupdocs.com/java/repo/com/groupdocs/groupdocs-metadata/) |
| Free support forum | [https://forum.groupdocs.com/c/metadata/](https://forum.groupdocs.com/c/metadata/) |
| Temporary license | [https://purchase.groupdocs.com/temp-license](https://purchase.groupdocs.com/temp-license) |

## MCP server (optional)

For IDE agents that support MCP, see [https://github.com/groupdocs-metadata/GroupDocs.Metadata.Mcp](https://github.com/groupdocs-metadata/GroupDocs.Metadata.Mcp). This examples repository demonstrates the **on-premise SDK** path.

## License

Apply a GroupDocs license before processing files without evaluation limitations:

```java
import com.groupdocs.metadata.License;

// Call once at application startup
new License().setLicense("path/to/GroupDocs.Metadata.lic");
```

Use a [temporary license](https://purchase.groupdocs.com/temp-license) for local development. Do not commit license files to this repository.

## API entry points

| Surface | Type | Notes |
|---------|------|-------|
| **This SDK** | `com.groupdocs.metadata.Metadata` | Primary entry |
| **Cloud Java SDK** | Cloud client types | **Not used in this repo** — requires Cloud credentials |
| **MCP** | MCP tools `ReadMetadata`, `RemoveMetadata` | Separate repo — [https://github.com/groupdocs-metadata/GroupDocs.Metadata.Mcp](https://github.com/groupdocs-metadata/GroupDocs.Metadata.Mcp) |

Typical SDK pattern:

```java
try (Metadata metadata = new Metadata("input.pdf")) {
    // read / edit / sanitize / save
    metadata.save("output.pdf");
}
```

API reference: [https://reference.groupdocs.com/metadata/java/](https://reference.groupdocs.com/metadata/java/)

## Example projects

<!-- Filled at generation time from repository tree and README headings. -->

Sample folders under `Examples/`:
- `Examples/Resources/`
- `Examples/src/`

Topics from [README.md](README.md):
- Read, Write, Update & Remove Document Metadata
- Get Started with GroupDocs.Metadata for Java
- Find Metadata Property via Tag
- Add or Update Metadata Properties Satisfying a Predicate

## Commands you can run

From the repository root (adjust module / main class to the sample you are running):

```bash
mvn -q -DskipTests package
mvn -q exec:java -Dexec.mainClass="com.groupdocs.metadata.examples.<SampleClass>"
```

Or open the project in IntelliJ IDEA / Eclipse and run the sample `main` method directly.

## House rules

1. **Stay on-platform** — generate **Java** code only; do not mix C#, Java, Python, and Node.js snippets from other GroupDocs.Metadata platforms unless the user explicitly asks for a comparison.
2. **Use canonical format count** — say **110+** (link to the formats table); never invent `60+`, `70+`, or `50+` counts.
3. **Prefer samples in this repo** — when adding or fixing examples, follow existing folder and naming conventions; reuse bundled sample files under `Examples/` (or equivalent) when present.
4. **License before full runs** — evaluation builds work with limitations until `SetLicense` / `setLicense` is applied; document the license path when adding new entry points.
5. **Link official docs** — API details belong in [https://reference.groupdocs.com/metadata/java/](https://reference.groupdocs.com/metadata/java/); keep AGENTS.md oriented to repository navigation and safe defaults.
6. **Do not commit secrets** — license files, Cloud client secrets, and API keys stay out of git.

## Do not change

- Do not delete or rewrite bundled sample documents/images used by existing examples.
- Do not change the NuGet / Maven / PyPI / npm package id (`GroupDocs.Metadata`) in install instructions.
- Do not replace SDK entry types with Cloud SDK types (`MetadataApi`, etc.).
- Do not add unrelated GroupDocs products (Conversion, Viewer, etc.) unless the sample explicitly requires them.
- Do not remove evaluation/license setup from runnable entry points without an explicit maintainer request.
