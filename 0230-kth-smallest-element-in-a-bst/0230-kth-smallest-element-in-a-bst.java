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
    Stack<Integer> s=new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
       if(root==null) return 0;
       solve(root);

       while(s.size()!=k){
            s.pop();
       }
       return s.peek();
    }

    void solve(TreeNode root){
        if(root==null){
            return;
        }

        if(root.left!=null){
            solve(root.left);
        }
        s.add(root.val);

        if(root.right!=null){
            solve(root.right);
        }
        return;
    }
}