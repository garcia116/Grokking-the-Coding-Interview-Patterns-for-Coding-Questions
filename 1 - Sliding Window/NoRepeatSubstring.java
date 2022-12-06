/*

Given a string, find the length of the longest substring, which has all distinct characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring with distinct characters is "abc".

Example 2:

Input: String="abbbb"
Output: 2
Explanation: The longest substring with distinct characters is "ab".

Example 3:

Input: String="abccde"
Output: 3
Explanation: Longest substrings with distinct characters are "abc" & "cde".

*/

import java.util.*;

public class NoRepeatSubstring {
    public static int findLength(String str){
        int maxLength = 0, windowStart = 0, windowEnd = 0;
        Set<Character> set = new HashSet<>();
        
        while(windowEnd < str.length()){
            if(!set.contains(str.charAt(windowEnd))){
                set.add(str.charAt(windowEnd++));
                maxLength = Math.max(maxLength, set.size());
                
            }
            else{
                set.remove(str.charAt(windowStart++));
            }
        }
        return maxLength;
    }
    public static void main(String args[]) {
System.out.println("Length of the longest substring: "
                + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: "
                + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: "
                + NoRepeatSubstring.findLength("abccde"));
    }
}
