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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        return height(root)!=-1 ;
    }
    int height(TreeNode root){
        if(root==null) return 0;
        int lmax=height(root.left);
        if(lmax==-1) return -1;

        int rmax=height(root.right);
        if(rmax==-1) return -1;

        if(Math.abs(lmax-rmax)>1) return -1;
        return 1+Math.max(lmax,rmax);
    }
}