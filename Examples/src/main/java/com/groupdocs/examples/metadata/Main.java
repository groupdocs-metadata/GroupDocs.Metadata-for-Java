package com.groupdocs.examples.metadata;

import com.groupdocs.examples.metadata.advanced_usage.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.wav.WavReadInfoMetadata;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.wav.WavReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.business_card.VCardFilterCardProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.business_card.VCardReadCardProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.business_card.VCardReadCardPropertiesWithParameters;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.cad.CadReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.cad.DxfUpdateNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.diagram.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.note.NoteReadDocumentStatistics;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.note.NoteReadInspectionProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.presentation.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management.ProjectManagementReadBuiltInProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management.ProjectManagementReadCustomProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management.ProjectManagementUpdateBuiltInProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management.ProjectManagementUpdateCustomProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.word_processing.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook.EpubReadDublinCoreProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook.EpubReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook.EpubUpdateDublinCoreProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook.EpubUpdateNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email.EmailRemoveAttachments;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email.EmailUpdateEmailFields;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email.EmlReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email.MsgReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.font.OpenTypeReadDigitalSignatureProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.font.OpenTypeReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.ImageReadFileFormatProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.bmp.BmpReadHeaderProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.dicom.DicomReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.dng.DngReadFileFormatProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.gif.GifReadFileFormatProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.JpegDetectBarcodes;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.JpegReadImageResourceBlocks;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.JpegRemoveImageResourceBlocks;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note.*;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg2000.Jpeg2000ReadComments;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.png.PngReadTextChunks;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.psd.PsdReadBasicExifProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.psd.PsdReadImageResourceBlocks;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.psd.PsdReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.raw.Cr2ReadFileFormatProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.tiff.TiffReadBasicIptcProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.peer2peer.TorrentReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.peer2peer.TorrentUpdateNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.asf.AsfReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.avi.AviReadHeaderProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.avi.AviReadInfoMetadata;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.flv.FlvReadHeaderProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.matroska.MatroskaReadNativeMetadataProperties;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.matroska.MatroskaReadSubtitles;
import com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.mov.MovReadQuickTimeAtoms;
import com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif.*;
import com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc.*;
import com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp.AddCustomXmpPackage;
import com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp.ReadXmpProperties;
import com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp.RemoveXmpMetadata;
import com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp.UpdateXmpProperties;
import com.groupdocs.examples.metadata.basic_usage.*;
import com.groupdocs.examples.metadata.quick_start.HelloWorld;
import com.groupdocs.examples.metadata.quick_start.licensing.SetLicenseFromStream;
import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.core.FileFormat;

public class Main {
    public static void main(String[] args) {
        System.out.println("Open `src/main/java/com/groupdocs/examples/metadata/Main.java` file. \nIn runExamples() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        runExamples();

        final boolean printFailedSamplesStacktrace = System.getenv("PRINT_FAILED_SAMPLES_STACKTRACE") != null;
        FailureRegister.getInstance().printFailedSamples(printFailedSamplesStacktrace);

        System.out.println("\nAll done.");
        System.exit(FailureRegister.getInstance().getFailedSamplesCount());
    }

    public static void runExamples() {
        // TODO: Comment examples which you don't want to run

        { // Licensing
//            SetLicenseFromFile.run();
            SetLicenseFromStream.run();
//            SetMeteredLicense.run();
        }
        { // Quick start
            HelloWorld.run(SampleFiles.INPUT_DOCX);
        }
        { // Basic usage
            CleanMetadata.run(SampleFiles.INPUT_DOCX);
            AddMetadata.run(SampleFiles.INPUT_FILES_DIRECTORY);
            RemoveMetadata.run(SampleFiles.INPUT_FILES_DIRECTORY);
            GenerateFilePreview.run(SampleFiles.INPUT_DOCX);
            GetDocumentInfo.run(SampleFiles.INPUT_XLSX);
            SetMetadata.run(SampleFiles.INPUT_FILES_DIRECTORY);
            UpdateMetadata.run(SampleFiles.INPUT_FILES_DIRECTORY);
        }
        { // Advanced usage
            ExportMetadataProperties.run(SampleFiles.INPUT_DOC);
            ExtractMetadata.run(SampleFiles.INPUT_FILES_DIRECTORY);
            FindMetadataProperties.byTag(SampleFiles.INPUT_PPTX);
            FindMetadataProperties.byTagGroup(SampleFiles.INPUT_VSDX);
            GetKnownPropertyDescriptors.run(SampleFiles.INPUT_DOC);
            ImportMetadata.run(SampleFiles.INPUT_PDF, SampleFiles.PDF_JSON);
            RemoveMetadataProperties.run(SampleFiles.INPUT_DOCX);
            SetMetadataProperties.run(SampleFiles.INPUT_VSDX);
            TraverseWholeMetadataTree.run(SampleFiles.JPEG_WITH_XMP);
            ProcessInterpretedValues.run(SampleFiles.INPUT_FILES_DIRECTORY);
            ExtractingPropertyValues.usingType(SampleFiles.INPUT_DOCX);
            ExtractingPropertyValues.usingAcceptor(SampleFiles.INPUT_DOCX);

            LoadFile.fromLocalDisk(SampleFiles.INPUT_ONE);
            LoadFile.fromStream(SampleFiles.INPUT_DOC);
            LoadFile.fileOfSpecificFormat(SampleFiles.INPUT_XLSX, FileFormat.Spreadsheet);
            LoadFile.protectedByPassword(SampleFiles.PROTECTED_DOCX, "123");

            SaveFile.toOriginalSource(SampleFiles.INPUT_PPT);
            SaveFile.toSpecifiedLocation(SampleFiles.INPUT_PNG);
            SaveFile.toSpecifiedStream(SampleFiles.INPUT_JPG);

            { // Managing metadata for specific file formats
                RarReadNativeMetadataProperties.run(SampleFiles.INPUT_RAR);
                SevenZipReadNativeMetadataProperties.run(SampleFiles.INPUT_7Z);
                TarReadNativeMetadataProperties.run(SampleFiles.INPUT_TAR);
                ZipReadNativeMetadataProperties.run(SampleFiles.INPUT_ZIP);
                ZipRemoveArchiveComment.run(SampleFiles.INPUT_ZIP);
                ZipUpdateArchiveComment.run(SampleFiles.INPUT_ZIP);

                MP3ReadApeTag.run(SampleFiles.INPUT_WITH_APE_MP3);
                MP3ReadID3V1Tag.run(SampleFiles.INPUT_WITH_ID3V1_MP3);
                MP3ReadID3V2Tag.run(SampleFiles.INPUT_WITH_ID3V2_MP3);
                MP3ReadLyricsTag.run(SampleFiles.INPUT_WITH_LYRICS_MP3);
                MP3ReadMpegAudioMetadata.run(SampleFiles.INPUT_WITH_ID3V2_MP3);
                MP3RemoveApeTag.run(SampleFiles.INPUT_WITH_APE_MP3);
                MP3RemoveID3V1Tag.run(SampleFiles.INPUT_WITH_ID3V1_MP3);
                MP3RemoveID3V2Tag.run(SampleFiles.INPUT_WITH_ID3V2_MP3);
                MP3RemoveLyricsTag.run(SampleFiles.INPUT_WITH_LYRICS_MP3);
                MP3UpdateID3V1Tag.run(SampleFiles.INPUT_WITH_ID3V1_MP3);
                MP3UpdateID3V2Tag.run(SampleFiles.INPUT_WITH_ID3V2_MP3);
                MP3UpdateLyricsTag.run(SampleFiles.INPUT_WITH_LYRICS_MP3);

                WavReadInfoMetadata.run(SampleFiles.INPUT_WAV);
                WavReadNativeMetadataProperties.run(SampleFiles.INPUT_WAV);

                VCardFilterCardProperties.run(SampleFiles.INPUT_VCF);
                VCardReadCardProperties.run(SampleFiles.INPUT_VCF);
                VCardReadCardPropertiesWithParameters.run(SampleFiles.INPUT_VCF);

                CadReadNativeMetadataProperties.run(SampleFiles.INPUT_DXF);
                DxfUpdateNativeMetadataProperties.run(SampleFiles.INPUT_DXF);

                DiagramReadBuiltInProperties.run(SampleFiles.INPUT_VSDX);
                DiagramReadCustomProperties.run(SampleFiles.INPUT_VSDX);
                DiagramReadDocumentStatistics.run(SampleFiles.INPUT_VDX);
                DiagramReadFileFormatProperties.run(SampleFiles.INPUT_VDX);
                DiagramUpdateBuiltInProperties.run(SampleFiles.INPUT_VDX);
                DiagramUpdateCustomProperties.run(SampleFiles.INPUT_VSDX);

                NoteReadDocumentStatistics.run(SampleFiles.INPUT_ONE);
                NoteReadInspectionProperties.run(SampleFiles.INPUT_ONE);

                PdfReadBuiltInProperties.run(SampleFiles.INPUT_PDF);
                PdfReadCustomProperties.run(SampleFiles.INPUT_PDF);
                PdfReadDocumentStatistics.run(SampleFiles.INPUT_PDF);
                PdfReadFileFormatProperties.run(SampleFiles.INPUT_PDF);
                PdfReadInspectionProperties.run(SampleFiles.INPUT_SIGNED_PDF);
                PdfUpdateBuiltInProperties.run(SampleFiles.INPUT_PDF);
                PdfUpdateCustomProperties.run(SampleFiles.INPUT_PDF);
                PdfUpdateInspectionProperties.run(SampleFiles.INPUT_SIGNED_PDF);

                PresentationReadBuiltInProperties.run(SampleFiles.INPUT_PPT);
                PresentationReadCustomProperties.run(SampleFiles.INPUT_PPTX);
                PresentationReadDocumentStatistics.run(SampleFiles.INPUT_PPT);
                PresentationReadFileFormatProperties.run(SampleFiles.INPUT_PPTX);
                PresentationReadInspectionProperties.run(SampleFiles.INPUT_PPT);
                PresentationUpdateBuiltInProperties.run(SampleFiles.INPUT_PPTX);
                PresentationUpdateCustomProperties.run(SampleFiles.INPUT_PPT);
                PresentationUpdateInspectionProperties.run(SampleFiles.INPUT_PPT);

                ProjectManagementReadBuiltInProperties.run(SampleFiles.INPUT_MPP);
                ProjectManagementReadCustomProperties.run(SampleFiles.INPUT_MPP);
                ProjectManagementUpdateBuiltInProperties.run(SampleFiles.INPUT_MPP);
                ProjectManagementUpdateCustomProperties.run(SampleFiles.INPUT_MPP);

                SpreadsheetReadBuiltInProperties.run(SampleFiles.INPUT_XLSX);
                SpreadsheetReadCustomProperties.run(SampleFiles.INPUT_XLS);
                SpreadsheetReadFileFormatProperties.run(SampleFiles.INPUT_XLSX);
                SpreadsheetReadInspectionProperties.run(SampleFiles.INPUT_XLS);
                SpreadsheetUpdateBuiltInProperties.run(SampleFiles.INPUT_XLSX);
                SpreadsheetUpdateCustomProperties.run(SampleFiles.INPUT_XLS);
                SpreadsheetUpdateInspectionProperties.run(SampleFiles.INPUT_XLSX);

                WordProcessingReadBuiltInProperties.run(SampleFiles.INPUT_DOCX);
                WordProcessingReadCustomProperties.run(SampleFiles.INPUT_DOC);
                WordProcessingReadDocumentStatistics.run(SampleFiles.INPUT_DOCX);
                WordProcessingReadDublinCoreProperties.run(SampleFiles.INPUT_DOCX);
                WordProcessingReadFileFormatProperties.run(SampleFiles.INPUT_DOC);
                WordProcessingReadInspectionProperties.run(SampleFiles.INPUT_DOCX);
                WordProcessingUpdateBuiltInProperties.run(SampleFiles.INPUT_DOC);
                WordProcessingUpdateCustomProperties.run(SampleFiles.INPUT_DOCX);
                WordProcessingUpdateDocumentStatistics.run(SampleFiles.INPUT_DOC);
                WordProcessingUpdateInspectionProperties.run(SampleFiles.INPUT_DOC);

                EpubReadDublinCoreProperties.run(SampleFiles.INPUT_EPUB);
                EpubReadNativeMetadataProperties.run(SampleFiles.INPUT_EPUB);
                EpubUpdateDublinCoreProperties.run(SampleFiles.INPUT_EPUB);
                EpubUpdateNativeMetadataProperties.run(SampleFiles.INPUT_EPUB);

                EmailRemoveAttachments.run(SampleFiles.INPUT_EML);
                EmailUpdateEmailFields.run(SampleFiles.INPUT_EML);
                EmlReadNativeMetadataProperties.run(SampleFiles.INPUT_EML);
                MsgReadNativeMetadataProperties.run(SampleFiles.INPUT_MSG);

                OpenTypeReadDigitalSignatureProperties.run(SampleFiles.INPUT_TTF);
                OpenTypeReadNativeMetadataProperties.run(SampleFiles.INPUT_TTF);

                BmpReadHeaderProperties.run(SampleFiles.INPUT_BMP);

                DicomReadNativeMetadataProperties.run(SampleFiles.INPUT_DICOM);

                DngReadFileFormatProperties.run(SampleFiles.INPUT_DNG);

                GifReadFileFormatProperties.run(SampleFiles.INPUT_GIF);

                MakerNoteReadAllTags.run(SampleFiles.CANON_JPEG);
                MakerNoteReadCanonProperties.run(SampleFiles.CANON_JPEG);
                MakerNoteReadNikonProperties.run(SampleFiles.NIKON_JPEG);
                MakerNoteReadPanasonicProperties.run(SampleFiles.PANASONIC_JPEG);
                MakerNoteReadSonyProperties.run(SampleFiles.SONY_JPEG);
                JpegDetectBarcodes.run(SampleFiles.INPUT_WITH_BARCODES_JPEG);
                JpegReadImageResourceBlocks.run(SampleFiles.INPUT_WITH_IRB_JPEG);
                JpegRemoveImageResourceBlocks.run(SampleFiles.INPUT_WITH_IRB_JPEG);

                Jpeg2000ReadComments.run(SampleFiles.INPUT_JP2);

                PngReadTextChunks.run(SampleFiles.INPUT_PNG);

                PsdReadBasicExifProperties.run(SampleFiles.EXIF_PSD);
                PsdReadImageResourceBlocks.run(SampleFiles.IRB_PSD);
                PsdReadNativeMetadataProperties.run(SampleFiles.IPTC_PSD);

                Cr2ReadFileFormatProperties.run(SampleFiles.INPUT_CR2);

                TiffReadBasicIptcProperties.run(SampleFiles.IPTC_TIFF);

                ImageReadFileFormatProperties.run(SampleFiles.INPUT_PNG);

                TorrentReadNativeMetadataProperties.run(SampleFiles.INPUT_TORRENT);
                TorrentUpdateNativeMetadataProperties.run(SampleFiles.INPUT_TORRENT);

                AsfReadNativeMetadataProperties.run(SampleFiles.INPUT_ASF);

                AviReadHeaderProperties.run(SampleFiles.INPUT_AVI);
                AviReadInfoMetadata.run(SampleFiles.INPUT_AVI);

                FlvReadHeaderProperties.run(SampleFiles.INPUT_FLV);

                MatroskaReadNativeMetadataProperties.run(SampleFiles.INPUT_MKV);
                MatroskaReadSubtitles.run(SampleFiles.SUBTITLES_MKV);

                MovReadQuickTimeAtoms.run(SampleFiles.INPUT_MOV);
            }

            { // Working with metadata standards
                ReadBasicExifProperties.run(SampleFiles.EXIF_TIFF);
                ReadExifTags.run(SampleFiles.EXIF_JPEG);
                ReadSpecificExifTag.run(SampleFiles.EXIF_TIFF);
                RemoveExifMetadata.run(SampleFiles.EXIF_JPEG);
                SetCustomExifTag.run(SampleFiles.EXIF_TIFF);
                UpdateExifProperties.run(SampleFiles.INPUT_JPG);

                AddRepeatableIptcDataSet.run(SampleFiles.IPTC_PSD);
                ReadBasicIptcProperties.run(SampleFiles.IPTC_JPEG);
                ReadIptcDataSets.run(SampleFiles.IPTC_PSD);
                RemoveIptcMetadata.run(SampleFiles.IPTC_JPEG);
                SetCustomIptcDataSet.run(SampleFiles.IPTC_JPEG);
                UpdateIptcProperties.run(SampleFiles.INPUT_JPG);

                AddCustomXmpPackage.run(SampleFiles.INPUT_JPG);
                ReadXmpProperties.run(SampleFiles.XMP_PNG);
                RemoveXmpMetadata.run(SampleFiles.XMP_JPG);
                UpdateXmpProperties.run(SampleFiles.XMP_GIF);
            }
        }
    }
}
