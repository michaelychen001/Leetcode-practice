import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Q139WordBreak {

    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new Boolean[n+1];
        return dfs(s, n, new HashSet<>(wordDict));
    }

    public boolean dfs(String s, int len, Set<String> dict) {
        if (len==0){
            return true;
        }

        if (memo[len] != null) {
            return memo[len];
        }

        memo[len] = false;
        for(int i=0; i < len; i++){
            boolean right = dict.contains(s.substring(i, len));
            if (!right) {
                continue;
            }

            boolean left = dfs(s, i, dict);
            if (left) {
                memo[len] = true;
                break;
            }
        }

        return memo[len];
    }

    public static void main(String[] args){
        System.out.println("***** Start *****");
        String str = "leetcode";

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        Q139WordBreak wb = new Q139WordBreak();
        wb.wordBreak(str, wordDict);

    }
}
