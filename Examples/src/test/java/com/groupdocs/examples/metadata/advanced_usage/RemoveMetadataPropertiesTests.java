package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class RemoveMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = RemoveMetadataProperties.run(SampleFiles.INPUT_DOCX);
        Assertions.assertThat(result).isNotNull().exists();
    }
}