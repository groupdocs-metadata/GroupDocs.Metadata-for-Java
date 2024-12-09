package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.raw;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.Cr2RootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class Cr2ReadFileFormatPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Cr2RootPackage result = Cr2ReadFileFormatProperties.run(SampleFiles.INPUT_CR2);
        Assertions.assertThat(result).isNotNull();
    }
}