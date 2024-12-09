package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.peer2peer;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.TorrentRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class TorrentReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        TorrentRootPackage result = TorrentReadNativeMetadataProperties.run(SampleFiles.INPUT_TORRENT);
        Assertions.assertThat(result).isNotNull();
    }
}