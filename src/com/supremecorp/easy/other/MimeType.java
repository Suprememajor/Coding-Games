package com.supremecorp.easy.other;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by suprememajor on the 9/24/21
 */
public class MimeType {
    public static void mimeType() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Hashtable<String, String> ht = new Hashtable<>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            System.err.println("EXT : " + EXT + " MT : " + MT);
            ht.put(EXT.toLowerCase(),MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.

            System.err.println("FNAME :" + FNAME);

            String Extension = "";
            if (FNAME.contains(".")) {
                Extension = FNAME.substring(FNAME.lastIndexOf(".") +1);
            }
            System.out.println(ht.getOrDefault(Extension.toLowerCase(), "UNKNOWN"));
        }
    }
}
