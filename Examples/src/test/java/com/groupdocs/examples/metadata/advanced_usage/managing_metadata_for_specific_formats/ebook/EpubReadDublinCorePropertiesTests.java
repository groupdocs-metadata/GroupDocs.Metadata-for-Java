package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.EpubRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class EpubReadDublinCorePropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        EpubRootPackage result = EpubReadDublinCoreProperties.run(SampleFiles.INPUT_EPUB);
        Assertions.assertThat(result).isNotNull();
    }
}