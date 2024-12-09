package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class JpegRemoveImageResourceBlocksTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = JpegRemoveImageResourceBlocks.run(SampleFiles.INPUT_WITH_IRB_JPEG);
        Assertions.assertThat(result).isNotNull().exists();
    }
}