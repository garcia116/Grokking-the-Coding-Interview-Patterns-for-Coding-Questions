/*
Given an array of positive numbers and a positive number âk,â find the maximum sum of any contiguous subarray of size âkâ.

Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Example 2:

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
*/

// Time: O(N)
// Space: O(1)
import java.util.Arrays;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr){
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;
        
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowStart]; // add next element
            // slide the window, check boundaries
            if(windowEnd >= k - 1){
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart++];
            }
        }
        
        return maxSum;
    }
    public static void main(String args[]) {
         System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }
}
