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
        if(height(root)==-1) return false;
        return true;
    }

    int height(TreeNode root){
        if(root==null) return 0;
        int i=0,j=0;
    
        if(root.left!=null){
            i= height(root.left);
        }
        if(root.right!=null){
            j= height(root.right);
        }

         if(i==-1 || j==-1){
            return -1;
        }

        if(Math.abs(i-j) >1) return -1;

        return 1+Math.max(i,j);
    }
}