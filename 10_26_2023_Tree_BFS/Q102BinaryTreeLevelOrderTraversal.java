import java.util.*;

/**
 * Definition for a binary tree node.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class Q102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new LinkedList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                if (tmp.left != null){
                    queue.offer(tmp.left);
                }
                if (tmp.right != null){
                    queue.offer(tmp.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
