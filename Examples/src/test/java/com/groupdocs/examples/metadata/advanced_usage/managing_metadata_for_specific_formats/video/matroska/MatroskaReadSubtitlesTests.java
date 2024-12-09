package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.matroska;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.MatroskaRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class MatroskaReadSubtitlesTests extends TestsSetUp {


    @Test
    void testRun() {
        MatroskaRootPackage result = MatroskaReadSubtitles.run(SampleFiles.SUBTITLES_MKV);
        Assertions.assertThat(result).isNotNull();
    }
}