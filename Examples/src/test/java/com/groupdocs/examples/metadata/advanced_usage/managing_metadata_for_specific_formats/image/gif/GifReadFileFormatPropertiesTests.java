package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.gif;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.GifRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class GifReadFileFormatPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        GifRootPackage result = GifReadFileFormatProperties.run(SampleFiles.INPUT_GIF);
        Assertions.assertThat(result).isNotNull();
    }
}