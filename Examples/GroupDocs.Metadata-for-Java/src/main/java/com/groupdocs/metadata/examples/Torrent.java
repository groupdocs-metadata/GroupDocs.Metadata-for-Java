package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.TorrentFileInfo;
import com.groupdocs.metadata.TorrentFormat;
import com.groupdocs.metadata.TorrentMetadata;
import com.groupdocs.metadata.examples.Utilities.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Torrent {
    // initialize file path
    private static String filePath = "\\Torrent\\Bit Torrent\\sample.torrent";
    public static class BitTorrent {
        public static void getTorrentMetadata() {
            try (TorrentFormat torrentFormat = new TorrentFormat(Common.mapSourceFilePath(filePath))) {

                TorrentMetadata info = torrentFormat.getTorrentInfo();
                System.out.println(info.getAnnounce());
                System.out.println(info.getCreatedBy());
                System.out.println(info.getCreationDate());
                System.out.println(info.getComment());
                System.out.println(info.getPieceLength());
                System.out.println(info.getPieces().length);

                for (TorrentFileInfo file : info.getSharedFiles()) {
                    System.out.println(file.getName());
                    System.out.println(file.getLength());
                }

                torrentFormat.dispose();
            }
        }

        public static void updateTorrentMedata() {
            try (TorrentFormat torrentFormat = new TorrentFormat(Common.mapSourceFilePath(filePath))) {

                TorrentMetadata info = torrentFormat.getTorrentInfo();

                info.setComment("test comment");
                info.setCreatedBy("test application");
                info.setCreationDate(new Date());

                torrentFormat.save(Common.mapDestinationFilePath(filePath));

                torrentFormat.dispose();
            }
        }

        public static void getTorrentMetadataUsingStream() {
            try (InputStream stream = new FileInputStream(Common.mapSourceFilePath(filePath)))
            {
                try (TorrentFormat format = new TorrentFormat(stream))
                {
                    TorrentMetadata info = format.getTorrentInfo();
                    System.out.println(info.getAnnounce());
                    System.out.println(info.getCreatedBy());
                    System.out.println(info.getCreationDate());
                    System.out.println(info.getComment());
                    System.out.println(info.getPieceLength());
                    System.out.println(info.getPieces().length);

                    for (TorrentFileInfo file : info.getSharedFiles()) {
                        System.out.println(file.getName());
                        System.out.println(file.getLength());
                    }
                    format.dispose();
                }
                // The stream is still open here
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
