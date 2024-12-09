// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.matroska;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;
import java.util.Arrays;

/**
 * This example demonstrates how to read Matroska format-specific metadata properties.
 */
public class MatroskaReadNativeMetadataProperties {
    public static MatroskaRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MatroskaRootPackage root = metadata.getRootPackageGeneric();

            // Read the EBML header
            System.out.printf("\tDocType: %s%n", root.getMatroskaPackage().getEbmlHeader().getDocType());
            System.out.printf("\tDocTypeReadVersion: %s%n", root.getMatroskaPackage().getEbmlHeader().getDocTypeReadVersion());
            System.out.printf("\tDocTypeVersion: %s%n", root.getMatroskaPackage().getEbmlHeader().getDocTypeVersion());
            System.out.printf("\tReadVersion: %s%n", root.getMatroskaPackage().getEbmlHeader().getReadVersion());
            System.out.printf("\tVersion: %s%n", root.getMatroskaPackage().getEbmlHeader().getVersion());

            // Read Matroska segment information
            for (MatroskaSegment segment : root.getMatroskaPackage().getSegments()) {
                System.out.printf("\t\tDateUtc: %s%n", segment.getDateUtc());
                System.out.printf("\t\tDuration: %s%n", segment.getDuration());
                System.out.printf("\t\tMuxingApp: %s%n", segment.getMuxingApp());
                System.out.printf("\t\tSegmentFilename: %s%n", segment.getSegmentFilename());
                System.out.printf("\t\tSegmentUid: %s%n", Arrays.toString(segment.getSegmentUid()));
                System.out.printf("\t\tTimecodeScale: %s%n", segment.getTimecodeScale());
                System.out.printf("\t\tTitle: %s%n", segment.getTitle());
                System.out.printf("\t\tWritingApp: %s%n", segment.getWritingApp());
            }

            // Read Matroska tag metadata
            for (MatroskaTag tag : root.getMatroskaPackage().getTags()) {
                System.out.printf("\t\tTargetType: %s%n", tag.getTargetType());
                System.out.printf("\t\tTargetTypeValue: %s%n", tag.getTargetTypeValue());
                System.out.printf("\t\tTagTrackUid: %s%n", tag.getTagTrackUid());
                for (MetadataProperty simpleTag : tag.getSimpleTags()) {
                    System.out.printf("\t\t\tName: %s%n", simpleTag.getName());
                    System.out.printf("\t\t\tValue: %s%n", simpleTag.getValue());
                }
            }

            // Read Matroska track metadata
            for (MatroskaTrack track : root.getMatroskaPackage().getTracks()) {
                System.out.printf("\t\tCodecId: %s%n", track.getCodecID());
                System.out.printf("\t\tCodecName: %s%n", track.getCodecName());
                System.out.printf("\t\tDefaultDuration: %s%n", track.getDefaultDuration());
                System.out.printf("\t\tFlagEnabled: %s%n", track.getFlagEnabled());
                System.out.printf("\t\tLanguage: %s%n", track.getLanguage());
                System.out.printf("\t\tLanguageIetf: %s%n", track.getLanguageIetf());
                System.out.printf("\t\tName: %s%n", track.getName());
                System.out.printf("\t\tTrackNumber: %s%n", track.getTrackNumber());
                System.out.printf("\t\tTrackType: %s%n", track.getTrackType());
                System.out.printf("\t\tTrackUid: %s%n", track.getTrackUid());

                if (track instanceof MatroskaAudioTrack) {
                    MatroskaAudioTrack audioTrack = (MatroskaAudioTrack) track;
                    System.out.printf("\t\tSamplingFrequency: %s%n", audioTrack.getSamplingFrequency());
                    System.out.printf("\t\tOutputSamplingFrequency: %s%n", audioTrack.getOutputSamplingFrequency());
                    System.out.printf("\t\tChannels: %s%n", audioTrack.getChannels());
                    System.out.printf("\t\tBitDepth: %s%n", audioTrack.getBitDepth());
                }

                if (track instanceof MatroskaVideoTrack) {
                    MatroskaVideoTrack videoTrack = (MatroskaVideoTrack) track;
                    System.out.printf("\t\tFlagInterlaced: %s%n", videoTrack.getFlagInterlaced());
                    System.out.printf("\t\tFieldOrder: %s%n", videoTrack.getFieldOrder());
                    System.out.printf("\t\tStereoMode: %s%n", videoTrack.getStereoMode());
                    System.out.printf("\t\tAlphaMode: %s%n", videoTrack.getAlphaMode());
                    System.out.printf("\t\tPixelWidth: %s%n", videoTrack.getPixelWidth());
                    System.out.printf("\t\tPixelHeight: %s%n", videoTrack.getPixelHeight());
                    System.out.printf("\t\tPixelCropBottom: %s%n", videoTrack.getPixelCropBottom());
                    System.out.printf("\t\tPixelCropTop: %s%n", videoTrack.getPixelCropTop());
                    System.out.printf("\t\tPixelCropLeft: %s%n", videoTrack.getPixelCropLeft());
                    System.out.printf("\t\tPixelCropRight: %s%n", videoTrack.getPixelCropRight());
                    System.out.printf("\t\tDisplayWidth: %s%n", videoTrack.getDisplayWidth());
                    System.out.printf("\t\tDisplayHeight: %s%n", videoTrack.getDisplayHeight());
                    System.out.printf("\t\tDisplayUnit: %s%n", videoTrack.getDisplayUnit());
                }
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
