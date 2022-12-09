/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

Example 1:

Input: [-1, 0, 2, 3], target=3 
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]

Example 2:

Input: [-1, 4, 2, 1, 3], target=5 
Output: 4
Explanation: There are four triplets whose sum is less than the target: 
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
*/

import java.util.*;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target){
        Arrays.sort(arr);
        int count = 0;
        for(int i=0; i < arr.length - 2; i++){
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }
    private static int searchPair(int[] arr, int targetSum, int first){
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr[right] < targetSum){
                count += right - left;
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
    public static void main(String args[]) {
    System.out.println(
        TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
    System.out.println(
        TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
