// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.matroska;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.examples.metadata.utils.FilesUtils;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MatroskaRootPackage;
import com.groupdocs.metadata.core.MatroskaSubtitle;
import com.groupdocs.metadata.core.MatroskaSubtitleTrack;

import java.nio.file.Path;

/**
 * This example demonstrates how to extract subtitles from an MKV video.
 */
public class MatroskaReadSubtitles {
    public static MatroskaRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MatroskaRootPackage root = metadata.getRootPackageGeneric();
            for (MatroskaSubtitleTrack subtitleTrack : root.getMatroskaPackage().getSubtitleTracks()) {
                System.out.printf("\tLanguage: %s%n", subtitleTrack.getLanguageIetf() != null ? subtitleTrack.getLanguageIetf() : subtitleTrack.getLanguage());
                for (MatroskaSubtitle subtitle : subtitleTrack.getSubtitles()) {
                    System.out.printf("\t\tTimecode=%s, Duration=%s%n", subtitle.getTimecode(), subtitle.getDuration());
                    final String subtitleText = subtitle.getText();
                    System.out.printf("\t\tText: %s%n", subtitleText.substring(0, Math.min(subtitleText.length(), 50)) + "...");
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
