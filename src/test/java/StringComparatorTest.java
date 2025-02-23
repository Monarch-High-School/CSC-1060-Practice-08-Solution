/**
 * Unit tests to test StringComparator.
 * @author J. Cihlar
 * @version 1.0
 * @since 2025-02
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StringComparatorTest {

    private StringComparator comparatorCommonWords;
    private StringComparator comparatorEmptySentences;
    private StringComparator comparatorCaseInsensitive;
    private StringComparator comparatorScrambledWords;

    // Sentence pairs
    private final String sentence1 = "The quick red fox";
    private final String sentence2 = "jumps over the lazy brown dog";
    private final String sentence3 = "";
    private final String sentence4 = "";
    private final String sentence5 = "This is the same sentence";
    private final String sentence6 = "THIS IS THE SAME SENTENCE";
    private final String sentence7 = "A man is not merely a beast";
    private final String sentence8 = "A beast is not merely a man";

    private final double DELTA = 1e-6;

    @BeforeEach
    public void setUp() {
        comparatorCommonWords = new StringComparator(sentence1, sentence2); // some in common
        comparatorEmptySentences = new StringComparator(sentence3, sentence4); // empty sentences
        comparatorCaseInsensitive = new StringComparator(sentence5, sentence6); // identical with case differences
        comparatorScrambledWords = new StringComparator(sentence7, sentence8); // identical with scrambled words
    }

    @Test
    public void testGetString1List_CommonWords() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("fox");
        expected.add("quick");
        expected.add("red");
        expected.add("the");

        ArrayList<String> actual = comparatorCommonWords.getString1List();
        assertEquals(expected, actual, "Test failed for getString1List with common words between sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetString2List_CommonWords() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("brown");
        expected.add("dog");
        expected.add("jumps");
        expected.add("lazy");
        expected.add("over");
        expected.add("the");

        ArrayList<String> actual = comparatorCommonWords.getString2List();
        assertEquals(expected, actual, "Test failed for getString2List with common words between sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetCommon_CommonWords() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("the");

        ArrayList<String> actual = comparatorCommonWords.getCommon();
        assertEquals(expected, actual, "Test failed for getCommon when comparing sentences with common words. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetUnique_CommonWords() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("brown");
        expected.add("dog");
        expected.add("fox");
        expected.add("jumps");
        expected.add("lazy");
        expected.add("over");
        expected.add("quick");
        expected.add("red");

        ArrayList<String> actual = comparatorCommonWords.getUnique();
        assertEquals(expected, actual, "Test failed for getUnique when comparing sentences with common words. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetSimilarityRatio_CommonWords() {
        double expected = 1.0/9.0; // 1 common word (the) / (9 words in total)
        double actual = comparatorCommonWords.getSimilarityRatio();
        assertEquals(expected, actual, DELTA, "Test failed for getSimilarityRatio with common words between two sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetString1List_EmptySentences() {
        int expected = 0;
    
        int actual = comparatorEmptySentences.getString1List().size();

        assertEquals(expected, actual, "Test failed for getString1List with empty sentences. Expected size: 0, Actual size: " + actual);
    }

    @Test
    public void testGetString2List_EmptySentences() {
        int expected = 0;
    
        int actual = comparatorEmptySentences.getString2List().size();

        assertEquals(expected, actual, "Test failed for getString2List with empty sentences. Expected size: 0, Actual size: " + actual);
    }

    @Test
    public void testGetCommon_EmptySentences() {
        int expected = 0;
    
        int actual = comparatorEmptySentences.getCommon().size();

        assertEquals(expected, actual, "Test failed for getCommon with empty sentences. Expected size: 0, Actual size: " + actual);
    }

    @Test
    public void testGetUnique_EmptySentences() {
        int expected = 0;
    
        int actual = comparatorEmptySentences.getUnique().size();

        assertEquals(expected, actual, "Test failed for getUnique with empty sentences. Expected size: 0, Actual size: " + actual);
    }

    @Test
    public void testGetSimilarityRatio_EmptySentences() {
        double expected = 1.0; // Both sentences are empty, so they are identical
        double actual = comparatorEmptySentences.getSimilarityRatio();
        assertEquals(expected, actual, DELTA, "Test failed for getSimilarityRatio with empty sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetString1List_CaseInsensitive() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("is");
        expected.add("same");
        expected.add("sentence");
        expected.add("the");
        expected.add("this");

        ArrayList<String> actual = comparatorCaseInsensitive.getString1List();
        assertEquals(expected, actual, "Test failed for getString1List with case-insensitive comparison of identical sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetString2List_CaseInsensitive() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("is");
        expected.add("same");
        expected.add("sentence");
        expected.add("the");
        expected.add("this");

        ArrayList<String> actual = comparatorCaseInsensitive.getString2List();
        assertEquals(expected, actual, "Test failed for getString2List with case-insensitive comparison of identical sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetCommon_CaseInsensitive() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("is");
        expected.add("same");
        expected.add("sentence");
        expected.add("the");
        expected.add("this");

        ArrayList<String> actual = comparatorCaseInsensitive.getCommon();
        assertEquals(expected, actual, "Test failed for getCommon with case-insensitive comparison of identical sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetUnique_CaseInsensitive() {
        ArrayList<String> expected = new ArrayList<String>();

        ArrayList<String> actual = comparatorCaseInsensitive.getUnique();
        assertEquals(expected, actual, "Test failed for getUnique with case-insensitive comparison of identical sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetSimilarityRatio_CaseInsensitive() {
        double expected = 1.0; // Both sentences are identical (case insensitive)
        double actual = comparatorCaseInsensitive.getSimilarityRatio();
        assertEquals(expected, actual, DELTA, "Test failed for getSimilarityRatio with case-insensitive comparison of identical sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetString1List_ScrambledWords() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("beast");
        expected.add("is");
        expected.add("man");
        expected.add("merely");
        expected.add("not");

        ArrayList<String> actual = comparatorScrambledWords.getString1List();
        assertEquals(expected, actual, "Test failed for getString1List with scrambled words. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetString2List_ScrambledWords() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("beast");
        expected.add("is");
        expected.add("man");
        expected.add("merely");
        expected.add("not");

        ArrayList<String> actual = comparatorScrambledWords.getString2List();
        assertEquals(expected, actual, "Test failed for getString2List with scrambled words. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetCommon_ScrambledWords() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("beast");
        expected.add("is");
        expected.add("man");
        expected.add("merely");
        expected.add("not");

        ArrayList<String> actual = comparatorScrambledWords.getCommon();
        assertEquals(expected, actual, "Test failed for getCommon with scrambled words in sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetUnique_ScrambledWords() {
        ArrayList<String> expected = new ArrayList<String>();

        ArrayList<String> actual = comparatorScrambledWords.getUnique();
        assertEquals(expected, actual, "Test failed for getUnique with scrambled words in sentences. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    public void testGetSimilarityRatio_ScrambledWords() {
        double expected = 1.0; // Both sentences have identical words, just scrambled
        double actual = comparatorScrambledWords.getSimilarityRatio();
        assertEquals(expected, actual, DELTA, "Test failed for getSimilarityRatio with scrambled words in sentences. Expected: " + expected + ", Actual: " + actual);
    }
}
