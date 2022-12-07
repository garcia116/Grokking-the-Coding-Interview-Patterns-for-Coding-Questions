/*

Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters, it will have n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.

*/

import java.util.*;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern){
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0, matched = 0;
        // add all characters from pattern into map
        for(char ch : pattern.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        // goal is to match all characters from the map with the current window
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar) - 1);
                if(map.get(rightChar) == 0) matched++;
            }
            // all characters in current window have matched
            if(matched == map.size()) return true;
            // slide the window range
            if(windowEnd - windowStart + 1 >= pattern.length()){
                char leftChar = str.charAt(windowStart++);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar) == 0) matched--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {
        System.out.println("Permutation exist: "
                + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: "
                + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: "
                + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: "
                + StringPermutation.findPermutation("aaacb", "abc"));
    }
}
