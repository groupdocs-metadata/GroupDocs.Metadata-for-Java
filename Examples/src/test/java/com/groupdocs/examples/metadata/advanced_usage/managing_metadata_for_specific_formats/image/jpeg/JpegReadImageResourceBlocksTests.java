package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.JpegRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class JpegReadImageResourceBlocksTests extends TestsSetUp {


    @Test
    void testRun() {
        JpegRootPackage result = JpegReadImageResourceBlocks.run(SampleFiles.INPUT_WITH_IRB_JPEG);
        Assertions.assertThat(result).isNotNull();
    }
}