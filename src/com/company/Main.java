package com.company;

import java.nio.file.Files;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileManager r = new FileManager();
        String data = r.readFromFile("originalText.txt");
        String positionsInput = r.readFromFile("positionsInput.txt");
        String hexIndexes[] = positionsInput.split(" ");


        ExtractText extractText = new ExtractText(data);
        extractText.setHexIndexes(hexIndexes);
        extractText.convertToDec();
        System.out.println(extractText.generateAnswer());
    }
}
