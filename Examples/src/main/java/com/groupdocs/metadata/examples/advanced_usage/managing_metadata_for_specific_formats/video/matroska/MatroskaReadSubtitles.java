// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.video.matroska;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MatroskaRootPackage;
import com.groupdocs.metadata.core.MatroskaSubtitle;
import com.groupdocs.metadata.core.MatroskaSubtitleTrack;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to extract subtitles from an MKV video.
 */
public class MatroskaReadSubtitles {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.MkvWithSubtitles)) {
            MatroskaRootPackage root = metadata.getRootPackageGeneric();

            for (MatroskaSubtitleTrack subtitleTrack : root.getMatroskaPackage().getSubtitleTracks()) {
                System.out.println(subtitleTrack.getLanguageIetf() != null ? subtitleTrack.getLanguageIetf() : subtitleTrack.getLanguage());
                for (MatroskaSubtitle subtitle : subtitleTrack.getSubtitles()) {
                    System.out.println(String.format("Timecode=%s, Duration=%s", subtitle.getTimecode(), subtitle.getDuration()));
                    System.out.println(subtitle.getText());
                }
            }
        }
    }
}
