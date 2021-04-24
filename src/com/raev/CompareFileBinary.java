package com.raev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class CompareFileBinary {
    public static boolean compare(File f1, File f2) {
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        try {
            fis1 = new FileInputStream(f1);
            fis2 = new FileInputStream(f2);
            byte [] p1 = new byte[1024];
            byte [] p2 = new byte[1024];
            int readBytesF1 = fis1.read(p1);
            int readBytesF2 = fis2.read(p2);
            System.out.println(readBytesF1);
            System.out.println(Arrays.toString(p1));
            System.out.println(readBytesF2);
            System.out.println(Arrays.toString(p2));
            while(true) {
                if ((readBytesF1 == -1 && readBytesF2 != -1) || (readBytesF1 != -1 && readBytesF2 == -1)) {
                    return false;
                }
                if (!Arrays.equals(p1, p2)){
                    return false;
                }
                if (readBytesF1 == -1 && readBytesF2 == -1 && Arrays.equals(p1, p2)){
                    return true;
                }
                readBytesF1 = fis1.read(p1);
                readBytesF2 = fis2.read(p2);
                System.out.println(readBytesF1);
                System.out.println(Arrays.toString(p1));
                System.out.println(readBytesF2);
                System.out.println(Arrays.toString(p2));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception");
        } catch (IOException ex) {
            System.out.println("Reading failed");
        }
        finally {
            try{
                fis1.close();
                fis2.close();
            } catch (IOException e) {
                System.out.println("Problem closing stream");
            } catch (NullPointerException e){
                System.out.println("Nullpointer exception");
            }

        }
        return false;
    }

    public static void main(String[] args) {
        File f1 = new File("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
        File f2 = new File("C:/Users/Public/Pictures/Sample Pictures/Desert2.jpg");
        File f3 = new File("C:/Users/Public/Pictures/Sample Pictures/Desert3.jpg");
        File f4 = new File("C:/Users/Public/Pictures/Sample Pictures/aaa.bmp");
        File f5 = new File("C:/Users/Public/Pictures/Sample Pictures/aa.bmp");
        System.out.println(compare(f1, f2));
        System.out.println(compare(f2, f3));
        System.out.println(compare(f1, f3));
        System.out.println(compare(f4, f5));
    }
}
