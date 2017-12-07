package com.groupdocs.metadata.examples.Utilities;

import com.groupdocs.metadata.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PhotoParser
{
    /**
     * <p>
     * Absolute path to the photos directory.
     * </p>
     */
    public final String getPhotosDirectory(){ return auto_PhotosDirectory; }
    /**
     * <p>
     * Absolute path to the photos directory.
     * </p>
     */
    public final void setPhotosDirectory(String value){ auto_PhotosDirectory = value; }
    private String auto_PhotosDirectory;

    public PhotoParser(String photosDirectory) throws FileNotFoundException
    {

        Path path = Paths.get(Common.mapSourceFilePath(photosDirectory));

        this.setPhotosDirectory(Common.mapSourceFilePath(photosDirectory));
    }

    public final String[] filterByCameraManufacturer(String manufacturer)
    {
        File dir = new File(getPhotosDirectory());

        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });

        java.util.List<String> result = new ArrayList<String>();

        for(File f: files)
        {
            String filePath = f.getAbsolutePath();

            // recognize file
            FormatBase format = FormatFactory.recognizeFormat(filePath);

            if(format.getType() == DocumentType.Jpeg)
            {
                JpegFormat jpeg = (JpegFormat)format;

                // get exif data
                JpegExifInfo exif = (JpegExifInfo)jpeg.getExifInfo();

                if (exif != null)
                {

                    if (exif.getMake() == manufacturer)
                    {
                        result.add(filePath);
                    }
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
