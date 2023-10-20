import java.util.LinkedHashMap;
import java.util.Map;

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

class Solution169 {
    public int majorityElement(int[] nums) {

        int majKey = -1;

        Map<Integer, Integer> myMap = new LinkedHashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (myMap.containsKey(k)) {
                int currValue = myMap.get(k);
                myMap.put(k, currValue + 1);
            } else {
                myMap.put(k, 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : myMap.entrySet()){
            if (e.getValue() > (Integer)(nums.length/2)){
                majKey = e.getKey();
            }
        }

        return majKey;
    }
}