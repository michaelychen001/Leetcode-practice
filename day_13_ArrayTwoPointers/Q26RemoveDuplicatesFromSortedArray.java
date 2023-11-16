class Q26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int i = 1;
        int j = 1;

        // 1) if i==0 and j==0 -> i++; j++;

        // 2) if i==j:
        //          if nums[i-1] != nums[i] -> i++; j++;
        //          else j++;
        //    else: #i!=j
        //          if nums[j] == nums[i-1] -> j++;
        //          else nums[i] = nums[j] -> i++; j++

        while(j < len){
            if (i==j) {
                if (nums[i-1] != nums[i]) {
                    i++;
                }
            } else {
                if (nums[i-1] != nums[j]) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            j++;
        }

        return i;
    }

    public static void main(String[] args){
        int[] nums = {1, 1, 2};
        Q26RemoveDuplicatesFromSortedArray sol = new Q26RemoveDuplicatesFromSortedArray();
        System.out.println(sol.removeDuplicates(nums));
    }

}