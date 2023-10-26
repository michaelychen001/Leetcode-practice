import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /*
        * Time: O(n)
        * Space: O(n)
        *
        */
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++){
            int currVal = nums[i];
            int diff = target - currVal;
            if (map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }else{
                map.put(currVal, i);
            }
        }

        return new int[2];
    }
}
