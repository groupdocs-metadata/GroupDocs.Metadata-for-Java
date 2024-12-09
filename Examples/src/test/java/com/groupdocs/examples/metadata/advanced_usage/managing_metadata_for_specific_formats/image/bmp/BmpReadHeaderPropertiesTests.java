package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.bmp;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.BmpRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class BmpReadHeaderPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        BmpRootPackage result = BmpReadHeaderProperties.run(SampleFiles.INPUT_BMP);
        Assertions.assertThat(result).isNotNull();
    }
}