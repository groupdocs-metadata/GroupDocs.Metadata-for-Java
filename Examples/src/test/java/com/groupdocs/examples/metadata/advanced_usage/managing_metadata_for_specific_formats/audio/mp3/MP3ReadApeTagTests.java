package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.mp3;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.MP3RootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class MP3ReadApeTagTests extends TestsSetUp {


    @Test
    void testRun() {
        MP3RootPackage result = MP3ReadApeTag.run(SampleFiles.INPUT_WITH_APE_MP3);
        Assertions.assertThat(result).isNotNull();
    }
}