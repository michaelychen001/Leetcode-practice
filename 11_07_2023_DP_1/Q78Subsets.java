import java.util.*;

class Q78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> cur, int index){
        if (index >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // current_subset + num[index]
        cur.add(nums[index]);
        dfs(res, nums, cur, index + 1);

        // current_subset
         cur.remove(cur.size() - 1);
         dfs(res, nums, cur, index + 1);


    }

    public static void main(String[] args){
        System.out.println("***** Start *****");
        int[] nums = {1, 2, 3};

        Q78Subsets sub = new Q78Subsets();
        List<List<Integer>> rt = sub.subsets(nums);
        System.out.println("***** Result *****");
    }
}
