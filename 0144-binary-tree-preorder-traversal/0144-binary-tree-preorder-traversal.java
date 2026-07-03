/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> sc=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return sc;
        order(root);

        return sc;
    }

    void order(TreeNode root){
        if(root==null) return ;
        sc.add(root.val);
        if(root.left!=null){
             order(root.left);
        }
        if(root.right!=null){
                order(root.right);
        }
            
    }
}