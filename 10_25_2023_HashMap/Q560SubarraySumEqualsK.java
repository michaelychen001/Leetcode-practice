import java.util.HashMap;
import java.util.Map;

public class Q560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int rs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            int tmp = sum - k;
            if (map.containsKey(tmp)){
                rs += map.get(tmp);
            }

            if (!map.containsKey(sum)){
                map.put(sum, 1);
            } else {
                map.put(sum, map.get(sum) + 1);
            }
        }

        return rs;
    }
}
