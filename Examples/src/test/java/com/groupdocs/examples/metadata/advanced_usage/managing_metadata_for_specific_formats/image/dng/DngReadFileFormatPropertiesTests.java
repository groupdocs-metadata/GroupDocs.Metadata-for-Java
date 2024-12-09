package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.dng;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.DngRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class DngReadFileFormatPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        DngRootPackage result = DngReadFileFormatProperties.run(SampleFiles.INPUT_DNG);
        Assertions.assertThat(result).isNotNull();
    }
}