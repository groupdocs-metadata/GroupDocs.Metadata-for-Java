package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.DiagramRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class DiagramReadDocumentStatisticsTests extends TestsSetUp {


    @Test
    void testRun() {
        DiagramRootPackage result = DiagramReadDocumentStatistics.run(SampleFiles.INPUT_VDX);
        Assertions.assertThat(result).isNotNull();
    }
}