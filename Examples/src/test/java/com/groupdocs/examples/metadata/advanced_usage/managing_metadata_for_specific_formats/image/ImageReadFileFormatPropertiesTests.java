package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.ImageRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class ImageReadFileFormatPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        ImageRootPackage result = ImageReadFileFormatProperties.run(SampleFiles.INPUT_PNG);
        Assertions.assertThat(result).isNotNull();
    }
}