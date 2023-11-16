class Q96UniqueBinarySearchTrees {

    Integer[] memo;
    public int numTrees(int n) {
        memo = new Integer[n+1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        int res = 0;
        for (int i=1; i<=n; i++) {
            int left = dfs(i-1);
            int right = dfs(n-i);
            res += left * right;
        }

        memo[n] = res;

        return res;
    }

}
