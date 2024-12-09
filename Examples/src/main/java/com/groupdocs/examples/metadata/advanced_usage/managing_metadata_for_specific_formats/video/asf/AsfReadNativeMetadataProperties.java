// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.asf;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to read native ASF metadata.
 */
public class AsfReadNativeMetadataProperties {
    public static AsfRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            AsfRootPackage root = metadata.getRootPackageGeneric();
            AsfPackage asfPackage = root.getAsfPackage();

            // Display basic properties
            System.out.printf("\tCreation date: %s%n", asfPackage.getCreationDate());
            System.out.printf("\tFile id: %s%n", asfPackage.getFileID());
            System.out.printf("\tFlags: %s%n", asfPackage.getFlags());

            // Display Asf Codec Information
            for (AsfCodec codecInfo : asfPackage.getCodecInformation()) {
                System.out.printf("\tCodec type: %s%n", codecInfo.getCodecType());
                System.out.printf("\tDescription: %s%n", codecInfo.getDescription());
                System.out.printf("\tCodec information: %s%n", codecInfo.getInformation());
                System.out.println(codecInfo.getName());
            }

            // Display metadata descriptors
            for (AsfBaseDescriptor descriptor : asfPackage.getMetadataDescriptors()) {
                System.out.printf("\tName: %s%n", descriptor.getName());
                System.out.printf("\tValue: %s%n", descriptor.getValue());
                System.out.printf("\tContent type: %s%n", descriptor.getAsfContentType());
                if (descriptor instanceof AsfMetadataDescriptor) {
                    AsfMetadataDescriptor metadataDescriptor = (AsfMetadataDescriptor) descriptor;
                    System.out.printf("\tLanguage: %s%n", metadataDescriptor.getLanguage());
                    System.out.printf("\tStream number: %s%n", metadataDescriptor.getStreamNumber());
                    System.out.printf("\tOriginal name: %s%n", metadataDescriptor.getOriginalName());
                }
            }

            //Display the base stream properties
            for (AsfBaseStreamProperty property : asfPackage.getStreamProperties()) {
                System.out.printf("\tAlternate bitrate: %s%n", property.getAlternateBitrate());
                System.out.printf("\tAverage bitrate: %s%n", property.getAverageBitrate());
                System.out.printf("\tAverage time per frame: %s%n", property.getAverageTimePerFrame());
                System.out.printf("\tBitrate: %s%n", property.getBitrate());
                System.out.printf("\tStream end time: %s%n", property.getEndTime());
                System.out.printf("\tStream flags: %s%n", property.getFlags());
                System.out.printf("\tStream language: %s%n", property.getLanguage());
                System.out.printf("\tStream start time: %s%n", property.getStartTime());
                System.out.printf("\tStream number: %s%n", property.getStreamNumber());
                System.out.printf("\tStream type: %s%n", property.getStreamType());

                //Display the audio stream properties
                if (property instanceof AsfAudioStreamProperty) {
                    AsfAudioStreamProperty audioStreamProperty = (AsfAudioStreamProperty) property;
                    System.out.printf("\tAudio bits per sample: %s%n", audioStreamProperty.getBitsPerSample());
                    System.out.printf("\tAudio channels: %s%n", audioStreamProperty.getChannels());
                    System.out.printf("\tAudio format tag: %s%n", audioStreamProperty.getFormatTag());
                    System.out.printf("\tAudio samples per second: %s%n", audioStreamProperty.getSamplesPerSecond());
                }

                //Display the video stream properties
                if (property instanceof AsfVideoStreamProperty) {
                    AsfVideoStreamProperty videoStreamProperty = (AsfVideoStreamProperty) property;
                    System.out.printf("\tVideo bits per pixels: %s%n", videoStreamProperty.getBitsPerPixels());
                    System.out.printf("\tCompression: %s%n", videoStreamProperty.getCompression());
                    System.out.printf("\tImage height: %s%n", videoStreamProperty.getImageHeight());
                    System.out.printf("\tImage width: %s%n", videoStreamProperty.getImageWidth());
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
