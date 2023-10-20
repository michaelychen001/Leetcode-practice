/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * */

public class Q352SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n-1;

        if (target <= nums[0]) {
            return 0;
        }

        if (target > nums[r]) {
            return r+1;
        }

        while(l < r-1) {
            int mid = l + (r - l)/2;

            if (nums[mid] == target) {
                // find it, and return the index.
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return r;
    }

    public static void main(String[] args) {

    }

}