package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class MP3UpdateID3V2TagTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = MP3UpdateID3V2Tag.run(SampleFiles.INPUT_WITH_ID3V2_MP3);
        Assertions.assertThat(result).isNotNull().exists();
    }
}