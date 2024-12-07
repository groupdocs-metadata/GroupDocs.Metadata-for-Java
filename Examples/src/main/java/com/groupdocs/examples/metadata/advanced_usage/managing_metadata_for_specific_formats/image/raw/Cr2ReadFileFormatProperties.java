package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.raw;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.Cr2CameraSettingsIndex;
import com.groupdocs.metadata.core.Cr2MakerNotePackage;
import com.groupdocs.metadata.core.Cr2RootPackage;
import com.groupdocs.metadata.core.RawShortTag;

import java.nio.file.Path;

/**
 * This code sample demonstrates how to get metadata from a Cr2 file.
 */
public class Cr2ReadFileFormatProperties {
    public static Cr2RootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            Cr2RootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Type: %s%n", root.getFileType().getFileFormat());
            System.out.printf("\tArtist: %s%n", root.getCr2Package().getRawTiffTagPackage().getArtist());
            System.out.printf("\tCopyright: %s%n", root.getCr2Package().getRawTiffTagPackage().getCopyright());
            System.out.printf("\tBody Serial Number: %s%n", root.getCr2Package().getRawTiffTagPackage().getRawExifTagPackage().getBodySerialNumber());
            Cr2MakerNotePackage cr2MakerNotePackage = (Cr2MakerNotePackage) root.getCr2Package().getRawTiffTagPackage().getRawExifTagPackage().getRawMakerNotePackage();
            System.out.printf("\tLens Type: %s%n", cr2MakerNotePackage.getCr2CameraSettingsPackage().getLensType());
            System.out.printf("\tMacro Mode: %s%n", cr2MakerNotePackage.getCr2CameraSettingsPackage().getMacroMode());
            RawShortTag propertyMacroMode = (RawShortTag) cr2MakerNotePackage.getCr2CameraSettingsPackage().get_Item(Cr2CameraSettingsIndex.MacroMode);
            System.out.printf("\tInterpreted Macro Mode: %s%n", propertyMacroMode.getInterpretedValue());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
