package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class RemoveIptcMetadataTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = RemoveIptcMetadata.run(SampleFiles.IPTC_JPEG);
        Assertions.assertThat(result).isNotNull().exists();
    }
}