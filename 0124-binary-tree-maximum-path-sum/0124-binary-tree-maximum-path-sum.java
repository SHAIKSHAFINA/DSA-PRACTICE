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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }

        solve(root);
        return res;//edges
    }
    int solve(TreeNode node){
        if(node==null){
            return 0;
        }
        int l=Math.max(0,solve(node.left));
        int r=Math.max(0,solve(node.right));
        
        int temp=node.val+Math.max(l,r); // node include
        int ans=Math.max(temp,node.val+l+r);//node eclude
        res=Math.max(res,ans);

        return temp;
    }
}