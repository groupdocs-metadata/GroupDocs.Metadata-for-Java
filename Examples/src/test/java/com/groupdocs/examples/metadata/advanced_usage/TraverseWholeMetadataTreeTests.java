package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.testng.annotations.Test;

class TraverseWholeMetadataTreeTests extends TestsSetUp {


    @Test
    void testRun() {
        TraverseWholeMetadataTree.run(SampleFiles.JPEG_WITH_XMP);
    }
}