package com.groupdocs.metadata.examples.Utilities;

import com.groupdocs.metadata.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PhotoCleaner
{
    // absolute path to GroupDocs.Metadata license
    private static final String LicensePath = "D:\\GroupDocs.Total.lic";

    public final String getCleanerPath(){ return auto_CleanerPath; }
    public final void setCleanerPath(String value){ auto_CleanerPath = value; }
    private String auto_CleanerPath;

    public PhotoCleaner(String cleanerPath) throws FileNotFoundException {
        Path path = Paths.get(Common.mapSourceFilePath(cleanerPath));

        this.setCleanerPath(Common.mapSourceFilePath(cleanerPath));
    }

    private static void setInternalLicense() {
        com.groupdocs.metadata.License license = new com.groupdocs.metadata.License();
        license.setLicense(LicensePath);
    }

    public final void removeExifLocation() {
        File dir = new File(getCleanerPath());

        // get array of files in specific directory
        File[] files = dir.listFiles();

        for (File f : files)
        {
            // get file absolute path
            String filePath = f.getAbsolutePath();

            // try to get EXIF metadata
            Metadata metadata = MetadataUtility.extractSpecificMetadata(filePath, MetadataType.EXIF);

            // cast to EXIF metadata if not null
            if (metadata != null)
            {
                ExifMetadata exifMetadata = (ExifMetadata)metadata;

                ExifInfo exifInfo = exifMetadata.getData();

                // check if EXIF contains GPS segment
                if (exifInfo.getGPSData() != null)
                {
                    // set altitude, latitude and longitude to null values
                    exifInfo.getGPSData().setAltitude(null);
                    exifInfo.getGPSData().setLatitude(null);
                    exifInfo.getGPSData().setLatitudeRef(null);
                    exifInfo.getGPSData().setLongitude(null);
                    exifInfo.getGPSData().setLongitudeRef(null);
                }

                // and update file
                MetadataUtility.updateMetadata(filePath, exifMetadata);
            }
        }
    }
    static /*PhotoCleaner()*/ {
        setInternalLicense();
    }
}
