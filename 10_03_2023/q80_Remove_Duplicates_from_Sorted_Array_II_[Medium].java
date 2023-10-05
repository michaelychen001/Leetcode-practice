/**
    Questions (Medium):
        Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that 
        each unique element appears at most twice. The relative order of the elements should be kept the same.

        Since it is impossible to change the length of the array in some languages, you must instead have the 
        result be placed in the first part of the array nums. More formally, if there are k elements after 
        removing the duplicates, then the first k elements of nums should hold the final result. It does not 
        matter what you leave beyond the first k elements.

        Return k after placing the final result in the first k slots of nums.

        Do not allocate extra space for another array. You must do this by modifying the input array in-place 
        with O(1) extra memory.
        
    Examples:
        Example 1:
            Input: nums = [1,1,1,2,2,3]
            Output: 5, nums = [1,1,2,2,3,_]
            Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
            It does not matter what you leave beyond the returned k (hence they are underscores).

        Example 2:
            Input: nums = [0,0,1,1,1,1,2,3,3]
            Output: 7, nums = [0,0,1,1,2,3,3,_,_]
            Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
            It does not matter what you leave beyond the returned k (hence they are underscores).
            
    (Ref: 
        https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
    )
*/

class Solution {
    public int[] removeAnElement(int[] nums, int indexToRemove){
        // Overwrite it
        for (int i = indexToRemove+1; i < nums.length; i++) {
            nums[i-1] = nums[i];
        }
        return nums;
    }

    public static void printNums(int[] nums){
        for (Integer i=0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("----");
    }

    public int removeDuplicates(int[] nums) {
        int i = 1;
        int count = 1;
        int length = nums.length;

        while(i < length){
            if(nums[i] == nums[i-1]){
                count++;
                if(count > 2){
                    this.removeAnElement(nums, i);
                    printNums(nums);
                    i--;
                    length--;
                }
            } else {
                count = 1;
            }
            i++;
        }
        return length;
    }
}