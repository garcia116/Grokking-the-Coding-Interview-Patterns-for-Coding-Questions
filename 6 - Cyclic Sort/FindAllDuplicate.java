/*
We are given an unsorted array containing n numbers taken from the range 1 to n. The array has some numbers appearing twice, find all these duplicate numbers using constant space.

Example 1:

Input: [3, 4, 4, 5, 5]
Output: [4, 5]
Example 2:

Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]

*/

import java.util.*;

public class FindAllDuplicate {
    public static List<Integer> findNumbers(int[] nums){
        int i = 0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }
            else {
                i++;
            }
        }
        List<Integer> duplicateNums = new ArrayList<>();
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                duplicateNums.add(nums[i]);
            }
        }
        return duplicateNums;
    }
    private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    }
    public static void main(String args[]) {
      List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 });
    System.out.println("Duplicates are: " + duplicates);

    duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
    System.out.println("Duplicates are: " + duplicates);
    }
}
