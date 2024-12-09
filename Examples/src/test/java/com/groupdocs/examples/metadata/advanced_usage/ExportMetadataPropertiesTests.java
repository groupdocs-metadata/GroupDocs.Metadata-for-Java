package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.List;

class ExportMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        List<Path> result = ExportMetadataProperties.run(SampleFiles.INPUT_DOC);
        Assertions.assertThat(result).isNotNull().hasSize(3);
    }
}