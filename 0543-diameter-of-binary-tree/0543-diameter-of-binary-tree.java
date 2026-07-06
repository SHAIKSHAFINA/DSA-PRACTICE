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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int x=height(root);
        return max;
    }
    int height(TreeNode root){
        if(root==null) return 0;
        int l=0,r=0;
        
        if(root.left!=null){
            l=height(root.left);
        }
        if(root.right!=null){
            r=height(root.right);
        }
        max=Math.max(max,l+r);
        return 1+Math.max(l,r);
    }
}