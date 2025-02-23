/**
 * This driver code will help you test the cases that are included in the unit tests.
 * @author J. Cihlar
 * @version 1.0
 * @since 2025-02  
 */


public class StringComparatorDriver {

    public static void main(String [] args) {

        String [] strings = new String[] { 
                // some words in common
            "The quick red fox",
            "jumps over the lazy brown dog",

                // empty strings
            "",
            "",
                // all words in common
            "This is the same sentence",
            "THIS IS THE SAME SENTENCE",

                // scrambled words in common
            "A man is not merely a beast",
            "A beast is not merely a man"
        };

        for (int i = 0; i < strings.length-1; i += 2) {
            StringComparator sc = new StringComparator(strings[i], strings[i+1]);
            System.out.println("---Comparing---");
            System.out.println("String 1: " + strings[i]);
            System.out.println("String 2: " + strings[i+1]);
            

            System.out.println("String 1 List: " + sc.getString1List());
            System.out.println("String 2 List: " + sc.getString2List());

            System.out.println("Common words: " + sc.getCommon());
            System.out.println("Unique words: " + sc.getUnique());
            System.out.println("Similarity ratio: " + sc.getSimilarityRatio());
            System.out.println();
        } 
    }
}