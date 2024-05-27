package org.example.MoodAnalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MoodAnalyzer {

    private static final Set<String> POSITIVE_WORDS = new HashSet<>();
    private static final Set<String> NEGATIVE_WORDS = new HashSet<>();

    static {
        POSITIVE_WORDS.add("хороший");
        POSITIVE_WORDS.add("прекрасный");
        POSITIVE_WORDS.add("отличный");
        POSITIVE_WORDS.add("замечательный");
        POSITIVE_WORDS.add("радостный");
        POSITIVE_WORDS.add("счастливый");

        NEGATIVE_WORDS.add("плохой");
        NEGATIVE_WORDS.add("ужасный");
        NEGATIVE_WORDS.add("отвратительный");
        NEGATIVE_WORDS.add("грустный");
        NEGATIVE_WORDS.add("несчастный");
        NEGATIVE_WORDS.add("тревожный");
    }

    public static int analyzeMood(String text) {
        int moodScore = 0;

        StringTokenizer tokenizer = new StringTokenizer(text, " ,.!?;:\n");

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();

            if (POSITIVE_WORDS.contains(word)) {
                moodScore++;
            } else if (NEGATIVE_WORDS.contains(word)) {
                moodScore--;
            }
        }

        return moodScore;
    }

    public static void main(String[] args) {
        String filePath = args[0];
        String content;

        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + e.getMessage());
            return;
        }
        int moodScore = analyzeMood(content);
        System.out.println("Настроение текста: " + moodScore);
    }
}
