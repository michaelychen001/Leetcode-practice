import java.util.*;

/**
 * Definition for a binary tree node.
 */

//class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class Q124BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        left = left > 0? left: 0;
        right = right > 0? right: 0;
        max = Math.max(max, left + right + node.val);
        return Math.max(left + node.val, right + node.val);
    }
}
