package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class UpdateXmpPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = UpdateXmpProperties.run(SampleFiles.XMP_GIF);
        Assertions.assertThat(result).isNotNull().exists();
    }
}