package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.peer2peer;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class TorrentUpdateNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = TorrentUpdateNativeMetadataProperties.run(SampleFiles.INPUT_TORRENT);
        Assertions.assertThat(result).isNotNull().exists();
    }
}