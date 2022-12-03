/*
Given an array, find the average of each subarray of ‘K’ contiguous elements in it.

Let’s understand this problem with a real input:

Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5

Here, we are asked to find the average of all subarrays of ‘5’ contiguous elements in the given array. Let’s solve this:

For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2
The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8
For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4
Here is the final output containing the averages of all  subarrays of size '5':

Output: [2.2, 2.8, 2.4, 3.6, 2.8]
*/

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int k, int[] arr){
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd]; // add next element
            // slide window, checking boundaries
            if(windowEnd >= k - 1){
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }
    public static void main(String args[]) {
         double[] result = AverageOfSubarrayOfSizeK.findAverages(5,
         new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 });
         System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
  }
}
