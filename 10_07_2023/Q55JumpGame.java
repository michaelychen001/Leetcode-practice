/**
    Questions:
        You are given an integer array nums. You are initially positioned at the array's first index, and each element
        in the array represents your maximum jump length at that position.

        Return true if you can reach the last index, or false otherwise.

    Example 1:
        Input: nums = [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
        Input: nums = [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it
        impossible to reach the last index.

    NOTE:
        This is the Dynamic Programming Bottom-up approach, which is done by eliminating recursion.




*/

class Solution55 {
    public boolean canJump(int[] nums) {
        // input = [2, 3, 1, 1, 4]
        //          g  g  g  g  g
        // input = [3, 2, 1, 0, 4]
        //          b  b  b  b  g

        /**
            Time complexity: O(n^2), i.e., 1 + 2 + ... + n-1 = (1 + n-1) * (n-1) / 2 = O(n^2)
            Space complexity: O(n) -> flags
        */

        int n = nums.length;

        // 1: good index; 0: bad index
        boolean[] flags = new boolean[n];

        for (int i=n-1; i>=0; i--) {
            if (i == n-1) {
                // the last element
                flags[i] = true;
            } else {
                // elements from 0 to n-2
                int tmpDist = nums[i];
                boolean rt = false;
                for (int j=i+1; j<=i+tmpDist; j++) {
                    if (flags[j] == true) {
                        rt = true;
                        break;
                    }
                }
                flags[i] = rt;
            }
        }

        // for (int k=0; k<flags.length; k++) {
        //     System.out.println(flags[k]);
        // }

        return flags[0];
    }
}