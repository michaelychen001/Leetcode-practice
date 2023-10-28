import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class Q104MaximumDepthOfBinaryTree {

    public int maxDepth_DFS(TreeNode root) {
        int level = 0;
        if (root == null){
            return level;
        }

        // if (root.left != null && root.right != null){
        //     return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        // } else if (root.left == null) {
        //     return 1 + maxDepth(root.right);
        // } else if (root.right == null) {
        //     return 1 + maxDepth(root.left);
        // } else {
        //     return 1;
        // }

        return 1 + Math.max(maxDepth_DFS(root.left), maxDepth_DFS(root.right));
    }

    public int maxDepth_BFS_Optimized(TreeNode root) {
        int level = 0;
        if (root == null){
            return level;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            level++;
        }

        return level;
    }
    public int maxDepth_BFS1(TreeNode root) {
        int level = 0;
        if (root == null){
            return level;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        level++;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean hasNextLevel = false;
            for (int i=0; i<size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    hasNextLevel = true;
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    hasNextLevel = true;
                }
            }

            if (hasNextLevel){
                level++;
            }
        }

        return level;
    }
}
