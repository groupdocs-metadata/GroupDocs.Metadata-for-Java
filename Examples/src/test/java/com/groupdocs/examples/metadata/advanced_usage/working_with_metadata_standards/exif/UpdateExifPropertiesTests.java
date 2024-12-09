package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class UpdateExifPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = UpdateExifProperties.run(SampleFiles.INPUT_JPG);
        Assertions.assertThat(result).isNotNull().exists();
    }
}