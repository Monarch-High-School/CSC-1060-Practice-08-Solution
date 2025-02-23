/**
 * This class contains the solution code for CSC 1060 Practice 8
 * @author J. Cihlar
 * @version 1.0
 * @since 2025-02
 */

import java.util.ArrayList;
import java.util.Collections;

public class StringComparator {
    private ArrayList<String> string1List;
    private ArrayList<String> string2List;
    private ArrayList<String> common;
    private ArrayList<String> unique;

    /**
     * Creates a StringComparator object from two Strings
     * @param a - the first String
     * @param b - the second String
     */
    public StringComparator(String a, String b) {
            // add items to the list if they aren't already there and sort
        string1List = new ArrayList<String>();
            // process if greater than 0
        if (a.length() > 0) {
            for (String s : a.toLowerCase().split(" "))  {
                addToList(string1List, s);
            }
        }
        string2List = new ArrayList<String>();
            // process if greater than 0
        if (b.length() > 2) {
            for (String s : b.toLowerCase().split(" ")) {
                addToList(string2List, s);
            }
        }
            // sort out the unique and common items
        determineCommonUnique();
    }

    public ArrayList<String> getString1List() {
        return string1List;
    }

    public ArrayList<String> getString2List() {
        return string2List;
    }

    public ArrayList<String> getCommon() {
        return common;
    }

    public ArrayList<String> getUnique() {
        return unique;
    }

    /**
     * Calculates a similarity ratio, which is defined as the number of 
     * common words divided by the total number of words.
     * @return double The number of common words divided by the total of the common and unique words.
     */
    public double getSimilarityRatio() {
            // if both lists are empty, then they were both empty strings
        if (unique.size() + common.size() == 0) return 1.0;

        return (double)common.size() / (common.size() + unique.size());
    }

    /**
     * Helper method to process the two arrays lists into common and unique ArrayLists.
     */
    private void determineCommonUnique() {
        common = new ArrayList<String>();
        unique = new ArrayList<String>();
            // loop through string1, and if items are in list2, add them to common    
        for (String w : string1List) {
            if (search(string2List, w)) {
                addToList(common, w);
            }
            else {
                addToList(unique, w);
            }
        }
        // loop through string2, and if items are in list1, add them to common    
        for (String w : string2List) {
            if (search(string1List, w)) {
                addToList(common, w);
            }
            else {
                addToList(unique, w);
            }
        }        
    }

    /**
     * Adds word to an ArrayList<Strings> if and only if it is not already in the list.
     * Sorts the list after an addition. 
     * Requires the list to be sorted and search binary search helper method
     * @param al The ArrayList<String> to add to. 
     * @param w The word to add
     */
    private void addToList(ArrayList<String> al, String w) {
        if (! search(al, w)) {
            al.add(w);
            Collections.sort(al);
        }
    }

    /**
     * Determines if a String is in an ArrayList of Strings.
     * It uses a binary search so the list must be sorted
     * @param al The sorted ArrayList of Strings to search
     * @param target The String to search for
     * @return boolean whether the item is found
     */
    private boolean search(ArrayList<String> al, String target) {
        int left = 0;
        int right = al.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = target.compareTo(al.get(mid));
                // found the item
            if (compare == 0) {
                return true;
            }
                // target is located in left side of list
            else if (compare < 0) {
                right = mid - 1;
            }
                // target is located in rigth side of list
            else {
                left = mid + 1;
            }
        }
            // target not found
        return false;
    }
}
