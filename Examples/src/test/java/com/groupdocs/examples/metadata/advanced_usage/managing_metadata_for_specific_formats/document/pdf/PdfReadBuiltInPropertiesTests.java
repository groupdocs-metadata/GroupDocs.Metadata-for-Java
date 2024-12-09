package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.PdfRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class PdfReadBuiltInPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        PdfRootPackage result = PdfReadBuiltInProperties.run(SampleFiles.INPUT_PDF);
        Assertions.assertThat(result).isNotNull();
    }
}