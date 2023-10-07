/**
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:
        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
        rotate 1 steps to the right: [7,1,2,3,4,5,6]
        rotate 2 steps to the right: [6,7,1,2,3,4,5]
        rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Ref: https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
*/

class Solution {
    public void rotate(int[] nums, int k) {

        /**
            Time: O(n)
            Space: O(n)
        */

        int length = nums.length;

        if (length < k) {
            k = k%length;
        }

        int[] kLeft = new int[length-k];

        // memorize the left part
        int p = 0;
        for (p=0; p < length-k; p++) {
            kLeft[p] = nums[p];
        }

        // shift the k elements
        int i;
        for (i=0; i < k; i++) {
            nums[i] = nums[p++];
        }

        // append the memorized elements
        for (int j=0; j < kLeft.length; j++) {
            nums[i++] = kLeft[j];
        }

    }
}

class Solution_2 {
    public void rotate(int[] nums, int k) {
        //
    }
}