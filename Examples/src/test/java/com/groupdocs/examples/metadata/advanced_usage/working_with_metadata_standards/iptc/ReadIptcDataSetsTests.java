package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IIptc;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class ReadIptcDataSetsTests extends TestsSetUp {


    @Test
    void testRun() {
        IIptc result = ReadIptcDataSets.run(SampleFiles.IPTC_PSD);
        Assertions.assertThat(result).isNotNull();
    }
}