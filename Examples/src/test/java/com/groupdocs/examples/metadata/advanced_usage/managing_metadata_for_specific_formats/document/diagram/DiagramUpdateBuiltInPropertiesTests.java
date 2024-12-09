package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class DiagramUpdateBuiltInPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = DiagramUpdateBuiltInProperties.run(SampleFiles.INPUT_VDX);
        Assertions.assertThat(result).isNotNull().exists();
    }
}