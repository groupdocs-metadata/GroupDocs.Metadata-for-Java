package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IXmp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class ReadXmpPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        IXmp result = ReadXmpProperties.run(SampleFiles.XMP_PNG);
        Assertions.assertThat(result).isNotNull();
    }
}