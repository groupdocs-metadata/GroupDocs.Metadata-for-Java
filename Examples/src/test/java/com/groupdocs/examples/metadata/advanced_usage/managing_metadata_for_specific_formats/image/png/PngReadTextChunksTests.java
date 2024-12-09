package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.png;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.PngRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class PngReadTextChunksTests extends TestsSetUp {


    @Test
    void testRun() {
        PngRootPackage result = PngReadTextChunks.run(SampleFiles.INPUT_PNG);
        Assertions.assertThat(result).isNotNull();
    }
}