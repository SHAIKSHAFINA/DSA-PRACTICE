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
    int c=0,ans=0;
    public int kthSmallest(TreeNode root, int k) {
       if(root==null) return 0;
       solve(root,k);

       return ans;
    }

    void solve(TreeNode root,int k){
        if(root==null){
            return;
        }

        if(root.left!=null){
            solve(root.left,k);
        }
       c++;
       if(c==k){
            ans=root.val;
            return;
       }

        if(root.right!=null){
            solve(root.right,k);
        }
        return;
    }
}