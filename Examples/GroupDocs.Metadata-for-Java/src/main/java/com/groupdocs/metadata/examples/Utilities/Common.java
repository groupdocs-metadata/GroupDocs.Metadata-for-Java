package com.groupdocs.metadata.examples.Utilities;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import com.groupdocs.metadata.*;

public class Common {

    public static final Path storagePath = getProjectBaseDir().resolve("Data/Source");
    public static final Path outputPath = getProjectBaseDir().resolve("Data/Destination");
    public static String licensePath = "D:\\GroupDocs.Total.Java.lic";
    public static String publicKey = "Public key for your account";
    public static String privateKey = "Private key for your account";

    // applies product license
    public static void applyLicenseFromFile() {
        try {
            // Setup license
            License lic = new License();
            lic.setLicense(licensePath.toString());
        } catch (Exception exp) {
            System.out.println("Exception: " + exp.getMessage());
            exp.printStackTrace();
        }
    }
    // returns project base directory
    public static Path getProjectBaseDir() {
        Properties props = new Properties();
        try {
            InputStream i = Common.class.getResourceAsStream("/project.properties");
            props.load(i);
        } catch (IOException x) {
            throw new RuntimeException(x);
        }
        return FileSystems.getDefault().getPath(props.getProperty("project.basedir"));
    }
    // returns source file path
    public static String mapSourceFilePath(String inputFileName) {
        try {
            return storagePath + inputFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return  e.getMessage();
        }
    }
    // returns output file path
    public static String mapDestinationFilePath(String outputFileName) {
        try {
            return outputPath + outputFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return  e.getMessage();
        }
    }
    // shows how to use library in licensed mode using Dynabic.Metered account
    public static void useDynabicMeteredAccount() {
        // initialize Metered API
        Metered metered = new Metered();

        // set-up credentials
        try {
            metered.setMeteredKey(publicKey, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // do some work:

        // open Word document
        DocFormat docFormat = new DocFormat(mapSourceFilePath("Documents/Doc/sample.doc"));

        // remove hidden metadata
        docFormat.removeHiddenData(new DocInspectionOptions(DocInspectorOptionsEnum.All));

        // and get consumption quantity
        try {
            Double consumptionQuantity = Metered.getConsumptionQuantity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // gets directory name and recognizes format of files in that directory
    public static void getFileFormats(String directorPath) {
        try
        {
            // path to the document
            directorPath = Common.mapSourceFilePath(directorPath);
            File dir = new File(directorPath);
            // get array of files in specific directory
            File[] files = dir.listFiles();

            for (File path : files)
            {
                // recognize file by it's signature
                FormatBase format = FormatFactory.recognizeFormat(path.getAbsolutePath());

                if (format != null)
                {
                    System.out.printf("File: %s, type: %s", path.getName(), format.getType());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
