package org.example.MoodAnalyzer;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.ru.RussianAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

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
        POSITIVE_WORDS.add("хорош");
        POSITIVE_WORDS.add("прекрас");
        POSITIVE_WORDS.add("отлич");
        POSITIVE_WORDS.add("замечатель");
        POSITIVE_WORDS.add("радост");
        POSITIVE_WORDS.add("счастл");

        NEGATIVE_WORDS.add("плох");
        NEGATIVE_WORDS.add("ужас");
        NEGATIVE_WORDS.add("отвратитель");
        NEGATIVE_WORDS.add("груст");
        NEGATIVE_WORDS.add("несчаст");
        NEGATIVE_WORDS.add("тревож");
    }

    public static int analyzeMood(String text) {
        int moodScore = 0;
        RussianAnalyzer analyzer = new RussianAnalyzer();
        TokenStream tokenStream = analyzer.tokenStream(null, text);
        try (tokenStream) {
            CharTermAttribute attr = tokenStream.addAttribute(CharTermAttribute.class);
            tokenStream.reset();

            while (tokenStream.incrementToken()) {
                String token = attr.toString();
                if (POSITIVE_WORDS.stream().anyMatch(token::startsWith)) {
                    moodScore++;
                } else if (NEGATIVE_WORDS.stream().anyMatch(token::startsWith)) {
                    moodScore--;
                }
            }

            tokenStream.end();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
