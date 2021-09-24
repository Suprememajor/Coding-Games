package com.supremecorp.easy.mine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by suprememajor on the 9/24/21
 */
public class MimeType {
    public static void mimeType() {
        Map<String, String> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            map.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();
        String[] fileExt = new String[Q];
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            fileExt[i] = getExtension(FNAME);
        }
        for(String extension: fileExt){
            String mimeType = map.get(extension);
                System.out.println( mimeType!=null ? mimeType : "UNKNOWN");
        }
    }
    public static String getExtension(String s){
        int R = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == '.'){
                R = i;
                break;
            }
        }
        return s.substring(R+1).toLowerCase();
    }
}
