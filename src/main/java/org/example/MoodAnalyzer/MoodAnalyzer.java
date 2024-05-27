package org.example.MoodAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MoodAnalyzer {

    public static void main(String[] args) {
        String filePath = args[0];
        String content;

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + e.getMessage());
            return;
        }


    }
}
