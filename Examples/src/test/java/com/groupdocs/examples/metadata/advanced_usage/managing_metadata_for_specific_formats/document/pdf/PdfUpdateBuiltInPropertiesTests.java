package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class PdfUpdateBuiltInPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = PdfUpdateBuiltInProperties.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(result).isNotNull().exists();
    }
}