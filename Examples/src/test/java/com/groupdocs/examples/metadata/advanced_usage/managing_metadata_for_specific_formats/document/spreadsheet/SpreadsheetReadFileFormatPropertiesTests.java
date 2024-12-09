package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class SpreadsheetReadFileFormatPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        SpreadsheetRootPackage result = SpreadsheetReadFileFormatProperties.run(SampleFiles.INPUT_XLSX);
        Assertions.assertThat(result).isNotNull();
    }
}