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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
          solve(root);
         return max;
    }

    int solve(TreeNode root){
        int l=0,r=0;
        if(root==null) return 0;
        
        if(root.left!=null){
             l= Math.max(0,solve(root.left));
        }
        if(root.right!=null){
             r= Math.max(0,solve(root.right));
        }
        max=Math.max(max,root.val+l+r);
        return root.val+Math.max(l,r);
    }
}