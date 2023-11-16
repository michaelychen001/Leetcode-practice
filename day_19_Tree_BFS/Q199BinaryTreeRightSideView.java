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

public class Q199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }

        // define queue
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if (i == size-1) {
                    res.add(curr.val);
                }
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }

        return res;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }

        // define queue
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            res.add(queue.peek().val);

            for (int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if (curr.right != null){
                    queue.offer(curr.right);
                }
                if (curr.left != null){
                    queue.offer(curr.left);
                }
            }
        }

        return res;
    }
}
