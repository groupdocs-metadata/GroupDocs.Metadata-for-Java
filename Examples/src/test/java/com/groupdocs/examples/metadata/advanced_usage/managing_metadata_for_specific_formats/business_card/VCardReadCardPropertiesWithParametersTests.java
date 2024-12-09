package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.business_card;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.VCardRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class VCardReadCardPropertiesWithParametersTests extends TestsSetUp {


    @Test
    void testRun() {
        VCardRootPackage result = VCardReadCardPropertiesWithParameters.run(SampleFiles.INPUT_VCF);
        Assertions.assertThat(result).isNotNull();
    }
}