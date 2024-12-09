package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class MP3UpdateLyricsTagTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = MP3UpdateLyricsTag.run(SampleFiles.INPUT_WITH_LYRICS_MP3);
        Assertions.assertThat(result).isNotNull().exists();
    }
}