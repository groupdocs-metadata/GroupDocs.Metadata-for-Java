package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.audio.wav;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.WavRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class WavReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        WavRootPackage result = WavReadNativeMetadataProperties.run(SampleFiles.INPUT_WAV);
        Assertions.assertThat(result).isNotNull();
    }
}