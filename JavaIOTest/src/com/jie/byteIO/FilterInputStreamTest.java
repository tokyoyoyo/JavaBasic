package com.jie.byteIO;

import java.io.*;

public class FilterInputStreamTest {
    public static void main(String[] args) throws IOException {

        byte[] data = "hello, world!".getBytes("UTF-8");
        try (CountInputStream countInputStream = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = countInputStream.read()) != -1){
                System.out.print((char) n);
            }
            System.out.println();
            System.out.println("Total read " + countInputStream.getBytesRead() + " bytes");
        }



    }
}


class CountInputStream extends FilterInputStream {
    private int count = 0;

    CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead() {
        return this.count;
    }

    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count ++;
        }
        return n;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}