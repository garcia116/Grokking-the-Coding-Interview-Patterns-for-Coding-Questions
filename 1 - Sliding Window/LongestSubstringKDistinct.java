/*
Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
*/

import java.util.*;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k){
        
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        // extend range
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char endChar = str.charAt(windowEnd);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            // shrink sliding window until left with 'k' distinct characters in Map
            while(map.size() > k){
                char startChar = str.charAt(windowStart);
                map.put(startChar, map.get(startChar) - 1);
                if(map.get(startChar) == 0){
                    map.remove(startChar);
                }
                windowStart++;
            }
            
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        
        return maxLength;
    }
    public static void main(String args[]) {
      System.out.println("Length of the longest substring: "
                + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: "
                + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: "
                + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
