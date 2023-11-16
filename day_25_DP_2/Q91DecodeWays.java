class Q91DecodeWays {

    Integer[] memo;
    public int numDecodings(String s) {
        int n = s.length();
        memo = new Integer[n + 1];
        return dfs(s, n);
    }

    private int dfs(String s, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        int res = 0;
        char x = s.charAt(n - 1), y = s.charAt(n-2) ;

        if (x != '0') {
            res += dfs(s, n - 1);
        }

        int yx = (y - '0') * 10 + (x - '0');
        if (yx >= 10 && yx <= 26) {
            res += dfs(s, n-2);
        }

        memo[n] = res;

        return res;
    }

}
