package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg2000;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.Jpeg2000RootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class Jpeg2000ReadCommentsTests extends TestsSetUp {


    @Test
    void testRun() {
        Jpeg2000RootPackage result = Jpeg2000ReadComments.run(SampleFiles.INPUT_JP2);
        Assertions.assertThat(result).isNotNull();
    }
}