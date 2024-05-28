package org.example.MoodAnalyzer;

import org.junit.Test;
import static org.junit.Assert.*;


public class MoodAnalyzerTest {

    @Test
    public void testAnalyzeMood_positive() {
        String text = "Этот день был замечательный и прекрасный. Я чувствую себя счастливым!";
        int moodScore = MoodAnalyzer.analyzeMood(text);
        assertTrue(moodScore > 0);

    }

    @Test
    public void testAnalyzeMood_negative() {
        String text = "Сегодня был ужасный и отвратительный день. Я чувствую себя грустным и несчастным.";
        int moodScore = MoodAnalyzer.analyzeMood(text);
        assertTrue(moodScore < 0);
    }

    @Test
    public void testAnalyzeMood_neutral() {
        String text = "Сегодня обычный день. Ничего особенного.";
        int moodScore = MoodAnalyzer.analyzeMood(text);
        assertEquals(0, moodScore);
    }

    @Test
    public void testAnalyzeMood_mixed() {
        String text = "Сегодня был замечательный день, но иногда было грустно.";
        int moodScore = MoodAnalyzer.analyzeMood(text);
        assertEquals(0, moodScore);
    }

    @Test
    public void testAnalyzeMood_empty() {
        String text = "";
        int moodScore = MoodAnalyzer.analyzeMood(text);
        assertEquals(0, moodScore);
    }
}
