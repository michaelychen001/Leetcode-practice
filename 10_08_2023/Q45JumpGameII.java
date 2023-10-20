/**
    Questions:
        You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if
        you are at nums[i], you can jump to any nums[i + j] where: 0 <= j <= nums[i] and i + j < n

        Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can
        reach nums[n - 1].

    Example 1:
        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
        Input: nums = [2,3,0,1,4]
        Output: 2

*/

class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;

        // 1: good index; 0: bad index
        boolean[] flags = new boolean[n];
        int[] numJumps = new int[n];

        for (int i=n-1; i>=0; i--) {
            if (i == n-1) {
                // the last element, and num of jump is 0.
                flags[i] = true;
                numJumps[i] = 0;
            } else {
                // elements from 0 to n-2
                int tmpDist = nums[i];
                boolean rt = false;
                int minJumpsIdx = -1;
                int minJumpNums = 1000000;

                int furtherestDist = Math.min(i+tmpDist, n-1);

                for (int j = i+1; j <= furtherestDist; j++) {
                    if (flags[j] == true) {
                        // can reach to the last element
                        rt = true;
                        if (numJumps[j] < minJumpNums) {
                            minJumpNums = numJumps[j];
                            minJumpsIdx = j;
                        }
                    }
                }
                flags[i] = rt;
                numJumps[i] = minJumpNums + 1;
            }
        }

        for (int k=0; k<flags.length; k++) {
            // System.out.println(flags[k]);
            System.out.println(numJumps[k]);
        }

        return numJumps[0];
    }
}