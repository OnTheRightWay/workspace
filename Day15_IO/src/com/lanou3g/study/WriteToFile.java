package com.lanou3g.study;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src/t1.txt");
        fw.write("将军角弓不得控，都护铁衣冷难着");
        fw.close();
    }
}
