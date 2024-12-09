package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class CleanMetadataTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = CleanMetadata.run(SampleFiles.INPUT_DOCX);
        Assertions.assertThat(result).isNotNull().exists();
    }
}