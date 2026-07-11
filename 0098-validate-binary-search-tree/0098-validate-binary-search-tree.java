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
    Stack<Integer> sc=new Stack<>();
    public boolean isValidBST(TreeNode root) {
        solve(root);
        
        while(!sc.isEmpty()){
            int x=sc.pop();
            if(!sc.isEmpty() && x<=sc.peek()){
                return false;
            }
        }

        return true;
    }

    void solve(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            solve(root.left);
        }

        sc.add(root.val);

        if(root.right!=null){
            solve(root.right);
        }

    }
}