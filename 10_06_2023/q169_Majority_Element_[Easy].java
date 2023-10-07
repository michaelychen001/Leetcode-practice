/**
    Given an array nums of size n, return the majority element.
    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

    Example 1:
        Input: nums = [3,2,3]
        Output: 3

    Example 2:
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2

    Ref: https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {

    public int removeElement(int[] nums, int val) {
        /**
            Solution-1: O(n)
        */
        int pStart = 0;
        int pEnd = length-1;

        while (pStart <= pEnd){
            if (nums[pStart] == val) {
                nums[pStart] = nums[pEnd];
                pEnd--;
            } else {
                pStart++;
            }
        }

        return pStart;

    }

    public int removeElement2(int[] nums, int val) {
        /**
            Solution-2: O(n)
        */
        int length = nums.length;
        int pStart = 0;

        while (pStart < length){
            if (nums[pStart] == val) {
                nums[pStart] = nums[length-1];
                length--;
            } else {
                pStart++;
            }
        }

        return length;
    }
}