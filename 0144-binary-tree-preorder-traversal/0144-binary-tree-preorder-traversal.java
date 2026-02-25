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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sc=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root==null) return sc;

        st.push(root);
        while(!st.isEmpty()){
            TreeNode x=st.pop();
            sc.add(x.val);
             if(x.right!=null){
                st.push(x.right);
            }
             if(x.left!=null){
                st.push(x.left);
            }

        }
        return sc;
    }
}