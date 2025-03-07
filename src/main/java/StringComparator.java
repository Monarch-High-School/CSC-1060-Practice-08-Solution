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
            // add items to the list 
        string1List = new ArrayList<String>();
            // process if greater than 0
        if (a.length() > 0) {
                // split on space and add to list
            for (String s : a.toLowerCase().split(" "))  {
                string1List.add(s);
            }
        }
            // sort
        Collections.sort(string1List);
            // remove duplicates
        removeDuplicates(string1List);

        string2List = new ArrayList<String>();
            // process if greater than 0
        if (b.length() > 2) {
            for (String s : b.toLowerCase().split(" ")) {
                string2List.add(s);
            }
        }
            // sort
        Collections.sort(string2List);
        removeDuplicates(string2List);

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
                common.add(w);
            }
            else {
                unique.add(w);
            }
        }
        // loop through string2, and if items are in list1, add them to common    
        for (String w : string2List) {
            if (search(string1List, w)) {
                common.add(w);
            }
            else {
                unique.add(w);
            }
        }        
        Collections.sort(common);
        Collections.sort(unique);
        removeDuplicates(common);
        removeDuplicates(unique);
    }

    /**
     * Removes duplicates from a sorted list. Operates on the list in place
     * @param list an ArrayList of Strings that is sorted
     */
    private void removeDuplicates(ArrayList<String> list) {
        int i = 0;
            // loop to the end of the list
        while (i < list.size() - 1) {
                // if this item and the following one are equal
                // remove the following item
            if (list.get(i).equals(list.get(i+1))) {
                list.remove(i+1);
            }
            else {
                i++;
            }
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
