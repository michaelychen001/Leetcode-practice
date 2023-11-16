import java.util.LinkedList;
import java.util.List;

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

public class Q112PathSum {
    List<Integer> pathSums = new LinkedList<Integer>();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, 0);

        if(pathSums.contains(targetSum)){
            return true;
        } else {
            return false;
        }
    }

    private void dfs(TreeNode node, int num) {
        num = num + node.val;

        if (node.left == null && node.right == null) {
            pathSums.add(num);
            return;
        }

        if (node.left != null) {
            dfs(node.left, num);
        }

        if (node.right != null) {
            dfs(node.right, num);
        }

    }
}
