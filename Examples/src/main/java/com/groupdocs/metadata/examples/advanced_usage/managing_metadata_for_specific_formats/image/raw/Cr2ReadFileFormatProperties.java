package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.raw;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.Cr2CameraSettingsIndex;
import com.groupdocs.metadata.core.Cr2MakerNotePackage;
import com.groupdocs.metadata.core.Cr2RootPackage;
import com.groupdocs.metadata.core.RawShortTag;
import com.groupdocs.metadata.examples.Constants;

/**
* This code sample demonstrates how to get metadata from a Cr2 file.
*/
public class Cr2ReadFileFormatProperties
{
    public static void run()
    {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # Cr2ReadFileFormatProperties : How to get metadata from a Cr2 file.\n");
        Metadata metadata = new Metadata(Constants.InputCr2);
        {
            Cr2RootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getFileType().getFileFormat());
            System.out.println(root.getCr2Package().getRawTiffTagPackage().getArtist());
            System.out.println(root.getCr2Package().getRawTiffTagPackage().getCopyright());
            System.out.println(root.getCr2Package().getRawTiffTagPackage().getRawExifTagPackage().getBodySerialNumber());
            Cr2MakerNotePackage cr2MakerNotePackage =
                    (Cr2MakerNotePackage) root.getCr2Package().getRawTiffTagPackage().getRawExifTagPackage().getRawMakerNotePackage();
            System.out.println(cr2MakerNotePackage.getCr2CameraSettingsPackage().getLensType());
            System.out.println(cr2MakerNotePackage.getCr2CameraSettingsPackage().getMacroMode());

            RawShortTag propertyMacroMode = (RawShortTag)cr2MakerNotePackage.getCr2CameraSettingsPackage().get_Item(Cr2CameraSettingsIndex.MacroMode);
            System.out.println(propertyMacroMode.getInterpretedValue());
        }
    }
}
