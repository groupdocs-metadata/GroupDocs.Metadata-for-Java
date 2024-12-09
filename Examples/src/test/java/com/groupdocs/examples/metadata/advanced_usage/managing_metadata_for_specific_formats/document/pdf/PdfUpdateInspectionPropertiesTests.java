package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class PdfUpdateInspectionPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = PdfUpdateInspectionProperties.run(SampleFiles.INPUT_SIGNED_PDF);
        Assertions.assertThat(result).isNotNull().exists();
    }
}