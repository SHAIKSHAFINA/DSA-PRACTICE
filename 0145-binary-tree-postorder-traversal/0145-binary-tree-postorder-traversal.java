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
    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> sc=new ArrayList<>();
       Stack<TreeNode> st1=new Stack<>();
       Stack<TreeNode> st2=new Stack<>();
       TreeNode node=root;
       if(root==null) return sc;

       st1.push(node);
       while(!st1.isEmpty()){
            TreeNode x=st1.pop();
            st2.push(x);
            if(x.left!=null){
                st1.push(x.left);
            }
             if(x.right!=null){
                st1.push(x.right);
            }
       }
       while(!st2.isEmpty()){
        TreeNode n=st2.pop();
            sc.add(n.val);
       }
       return sc;

    }
}