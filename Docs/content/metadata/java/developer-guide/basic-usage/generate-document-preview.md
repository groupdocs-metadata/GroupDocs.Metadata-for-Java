---
id: generate-document-preview
url: metadata/java/generate-document-preview
title: Generate document preview
weight: 6
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
If you need to implement a UI for your application it can be useful to generate image previews for a document the users are going to work with. Such previews can be easily displayed on a web page or in an appropriate component of a desktop/mobile application. The code sample below demonstrates how to generate image previews for certain document pages.

Here are the steps to generate a document preview for a particular page:

1.  [Load]({{< ref "metadata/java/developer-guide/basic-usage/generate-document-preview.md" >}}) a document to preview
2.  Specify a delegate that will be used to create the page streams (please see the [ICreatePageStream](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.options/ICreatePageStream) interface for more information)
3.  Specify the page numbers
4.  Generate previews for desired pages using the [generatePreview](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata#generatePreview(com.groupdocs.metadata.options.PreviewOptions)) method of the [Metadata](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata/Metadata) class

**basic\_usage.GenerateFilePreview**

```csharp
public class GenerateFilePreview {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            PreviewOptions previewOptions = new PreviewOptions(new GenerateFilePreview().new CreatePageStream());
            previewOptions.setPreviewFormat(PreviewOptions.PreviewFormats.PNG);
            previewOptions.setPageNumbers(new int[]{1});
            metadata.generatePreview(previewOptions);
        }
    }

    private class CreatePageStream implements ICreatePageStream {
        @Override
        public OutputStream createPageStream(int pageNumber) {
            File file = new File(String.format("%s\\result_%s.png", Constants.OutputPath, pageNumber));
            OutputStream stream = null;
            try {
                stream = new FileOutputStream(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return stream;
        }
    }
}
```

## More resources

### Advanced usage topics

To learn more about library features and get familiar how to manage metadata and more, please refer to the[advanced usage section]({{< ref "metadata/java/developer-guide/advanced-usage/_index.md" >}}).

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with a full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
