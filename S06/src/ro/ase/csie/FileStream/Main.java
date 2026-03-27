package ro.ase.csie.FileStream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        //try-catch to not crash our program
        try {
            fos = new FileOutputStream("out.bin");
            bos = new BufferedOutputStream(fos);
            bos.write(21); //binary
            bos.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

        FileOutputStream fos2 = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            fos2 = new FileOutputStream("out.txt");
            osw = new OutputStreamWriter(fos2);
            bw = new BufferedWriter(osw);
            bw.write("Hello!");
//            Integer x = 5; //hack to bypass binary writing and force integer write
//            bw.write(x.toString());
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            FileInputStream fis = new FileInputStream("in.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String input = br.readLine();
            System.out.println(input);
            br.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
















    }
}
