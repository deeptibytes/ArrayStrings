package easy;

import java.util.*;

public class EasySolution {

    /**
      Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
     */

    //Using set
    // Time = O(N)
    // Space = O(N)
    public static boolean isUniqueStringSet(String input) {
        Set<Character> set = new HashSet();

        for (int i = 0; i < input.length(); i++) {
            if (set.contains(input.charAt(i))) {
                return false;
            }
            set.add(input.charAt(i));

        }
        return true;
    }

    //Using boolean array - Time = O(N)  Space = O(1)
    public static boolean isUniqueStringArray(String input) {

        boolean[] arr = new boolean[128];

        for (int i = 0; i < input.length(); i++) {
            if (arr[input.charAt(i)]) {
                return false;
            }
            arr[input.charAt(i)] = true;

        }
        return true;
    }

    //without using any DS - Time = O(N square)  Space = O(1)
    //abcaa    abcbd
    public static boolean isUniqueStringNoDS(String input) { //Brute force way
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {

                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }

        }
        return true;
    }
  /**
     Check Permutation: Given two strings,write a method to decide if one is a permutation of the other string.
  */
    //Time = O(N)
    //Space =O(N)
    public static boolean isPermutation(String one, String two) {

        if(one.length() != two.length()) return false;

        Map<Character, Integer> map1 = new HashMap();
        for(int i = 0 ; i < one.length(); i++){
            Character charAti = one.charAt(i);
            map1.put(charAti, map1.getOrDefault(charAti, 0) + 1);
        }

        for(int i = 0 ; i < two.length(); i++){
            Character charAti = two.charAt(i);
            if(! map1.containsKey(charAti))return false;
            map1.put(charAti, map1.getOrDefault(charAti, 0) - 1);
            if(map1.get(charAti) < 0) return false;
        }
        return true;
    }
    //Time = O(N)
    //Space =O(1)
    public static boolean isPermutationSeconddWay(String one, String two) {
        if(one.length() != two.length()) return false;

        int[] arr = new int[52];//since string contains only chars (english letters). If this is not given, then use 128
        for(int i = 0 ; i < one.length(); i++){
            Character charAti = one.charAt(i);
            arr[charAti] = arr[charAti]++;
        }

        for(int i = 0 ; i < two.length(); i++){
            Character charAti = one.charAt(i);
            arr[charAti] = arr[charAti]--; //if count of char is same, it will be zero. If less than zero, means counts if char is more in two
            if(arr[charAti] < 0) return false;
        }

        return true;
    }


    //Time = O(nLogn + mlogm)
    //Space = O(1) ??
    public static boolean isPermutationThirddWay(String one, String two) {
        if(one.length() != two.length()) return false;
        //sort both of them and then compare Sorting takes O(nLogn + mlogm) where n and m are the length of strings
        return sort(one).equals(sort(two));
    }

    private static String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return arr.toString();
    }

    /*
     URLify: Write a method to replace all spaces in a string with '%20'.
     You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the
     "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
     */




    /*
    Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­ drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.) Hints:#106,#121,#134,#136

     */


    /*
     One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
EXAMPLE
pale, ple -> true pales, pale -> true pale, bale -> true pale, bake -> false
     */


    /*
     String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
Hints:#92, #110
     */

    /*
      Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
     */

    /*
     Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0
     */

    /*
     String Rotation:Assumeyou have a method isSubstringwhich checks if one word is a substring of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").

     */

    public static void main(String[] args) {

        String str = "abcd";
        //System.out.println(isUniqueStringNoDS(str));
        System.out.println(isUniqueStringArray(str));


    }
}
