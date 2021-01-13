// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.video.matroska;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to read Matroska format-specific metadata properties.
 */
public class MatroskaReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputMkv)) {
            MatroskaRootPackage root = metadata.getRootPackageGeneric();

            // Read the EBML header
            System.out.println(String.format("DocType: %s", root.getMatroskaPackage().getEbmlHeader().getDocType()));
            System.out.println(String.format("DocTypeReadVersion: %s", root.getMatroskaPackage().getEbmlHeader().getDocTypeReadVersion()));
            System.out.println(String.format("DocTypeVersion: %s", root.getMatroskaPackage().getEbmlHeader().getDocTypeVersion()));
            System.out.println(String.format("ReadVersion: %s", root.getMatroskaPackage().getEbmlHeader().getReadVersion()));
            System.out.println(String.format("Version: %s", root.getMatroskaPackage().getEbmlHeader().getVersion()));

            // Read Matroska segment information
            for (MatroskaSegment segment : root.getMatroskaPackage().getSegments()) {
                System.out.println(String.format("DateUtc: %s", segment.getDateUtc()));
                System.out.println(String.format("Duration: %s", segment.getDuration()));
                System.out.println(String.format("MuxingApp: %s", segment.getMuxingApp()));
                System.out.println(String.format("SegmentFilename: %s", segment.getSegmentFilename()));
                System.out.println(String.format("SegmentUid: %s", segment.getSegmentUid()));
                System.out.println(String.format("TimecodeScale: %s", segment.getTimecodeScale()));
                System.out.println(String.format("Title: %s", segment.getTitle()));
                System.out.println(String.format("WritingApp: %s", segment.getWritingApp()));
            }

            // Read Matroska tag metadata
            for (MatroskaTag tag : root.getMatroskaPackage().getTags()) {
                System.out.println(String.format("TargetType: %s", tag.getTargetType()));
                System.out.println(String.format("TargetTypeValue: %s", tag.getTargetTypeValue()));
                System.out.println(String.format("TagTrackUid: %s", tag.getTagTrackUid()));
                for (MetadataProperty simpleTag : tag.getSimpleTags()) {
                    System.out.println(String.format("Name: %s", simpleTag.getName()));
                    System.out.println(String.format("Value: %s", simpleTag.getValue()));
                }
            }

            // Read Matroska track metadata
            for (MatroskaTrack track : root.getMatroskaPackage().getTracks()) {
                System.out.println(String.format("CodecId: %s", track.getCodecID()));
                System.out.println(String.format("CodecName: %s", track.getCodecName()));
                System.out.println(String.format("DefaultDuration: %s", track.getDefaultDuration()));
                System.out.println(String.format("FlagEnabled: %s", track.getFlagEnabled()));
                System.out.println(String.format("Language: %s", track.getLanguage()));
                System.out.println(String.format("LanguageIetf: %s", track.getLanguageIetf()));
                System.out.println(String.format("Name: %s", track.getName()));
                System.out.println(String.format("TrackNumber: %s", track.getTrackNumber()));
                System.out.println(String.format("TrackType: %s", track.getTrackType()));
                System.out.println(String.format("TrackUid: %s", track.getTrackUid()));

                if (track instanceof MatroskaAudioTrack) {
                    MatroskaAudioTrack audioTrack = (MatroskaAudioTrack) track;
                    System.out.println(String.format("SamplingFrequency: %s", audioTrack.getSamplingFrequency()));
                    System.out.println(String.format("OutputSamplingFrequency: %s", audioTrack.getOutputSamplingFrequency()));
                    System.out.println(String.format("Channels: %s", audioTrack.getChannels()));
                    System.out.println(String.format("BitDepth: %s", audioTrack.getBitDepth()));
                }

                if (track instanceof MatroskaVideoTrack) {
                    MatroskaVideoTrack videoTrack = (MatroskaVideoTrack) track;
                    System.out.println(String.format("FlagInterlaced: %s", videoTrack.getFlagInterlaced()));
                    System.out.println(String.format("FieldOrder: %s", videoTrack.getFieldOrder()));
                    System.out.println(String.format("StereoMode: %s", videoTrack.getStereoMode()));
                    System.out.println(String.format("AlphaMode: %s", videoTrack.getAlphaMode()));
                    System.out.println(String.format("PixelWidth: %s", videoTrack.getPixelWidth()));
                    System.out.println(String.format("PixelHeight: %s", videoTrack.getPixelHeight()));
                    System.out.println(String.format("PixelCropBottom: %s", videoTrack.getPixelCropBottom()));
                    System.out.println(String.format("PixelCropTop: %s", videoTrack.getPixelCropTop()));
                    System.out.println(String.format("PixelCropLeft: %s", videoTrack.getPixelCropLeft()));
                    System.out.println(String.format("PixelCropRight: %s", videoTrack.getPixelCropRight()));
                    System.out.println(String.format("DisplayWidth: %s", videoTrack.getDisplayWidth()));
                    System.out.println(String.format("DisplayHeight: %s", videoTrack.getDisplayHeight()));
                    System.out.println(String.format("DisplayUnit: %s", videoTrack.getDisplayUnit()));
                }
            }
        }
    }
}
