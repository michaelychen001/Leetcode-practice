import java.util.*;

class Q70ClimbingStairs {


     public int climbStairs(int n) {

        List<Integer> memo = new ArrayList<Integer>();

        for (int i=0; i < n; i++) {
            if (i == 0) {
                memo.add(i, 1);
            } else if (i == 1) {
                memo.add(i, 2);
            } else {
                int tmp = memo.get(i-1) + memo.get(i-2);
                memo.add(i, tmp);
            }
        }

        return memo.get(n-1);

    }

    public static void main(String[] args){
        System.out.println("***** Start *****");

        Q70ClimbingStairs sol = new Q70ClimbingStairs();
        int rt = sol.climbStairs(44);
        System.out.println(rt);

        System.out.println("***** Result *****");
    }
}

//class Q70ClimbingStairs {
//
//
//    Map<Integer, Integer> memo = new HashMap<>();
//
//    public int climbStairs(int n) {
//        memo.put(0, 1);
//        memo.put(1, 1);
//        memo.put(2, 2);
//        return dfs(n);
//    }
//
//    public int dfs(int len){
//        if (len == 0 || len == 1) {
//            return 1;
//        }
//
//        if (len == 2) {
//            return 2; // 2 or 1+1
//        }
//
//        if (memo.containsKey(len)) {
//            return memo.get(len);
//        }
//
//        // take 1 step
//        int oneStep;
//        if (memo.containsKey(len-1)){
//            System.out.println("** one step");
//            oneStep = memo.get(len-1);
//        } else {
//            oneStep = dfs(len-1);
//        }
//
//        // take 2 steps
//        int twoSteps;
//        if (memo.containsKey(len-2)){
//            System.out.println("** two steps");
//            twoSteps = memo.get(len-2);
//        } else {
//            twoSteps = dfs(len-2);
//        }
//
//        return oneStep + twoSteps;
//    }
//
//    public static void main(String[] args){
//        System.out.println("***** Start *****");
//
//        Q70ClimbingStairs sol = new Q70ClimbingStairs();
//        int rt = sol.climbStairs(44);
//        System.out.println(rt);
//
//        System.out.println("***** Result *****");
//    }
//}
