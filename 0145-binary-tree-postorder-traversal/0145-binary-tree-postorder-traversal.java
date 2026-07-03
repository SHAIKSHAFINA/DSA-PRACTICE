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
        Stack<TreeNode> s=new Stack<>();
        Stack<TreeNode> t=new Stack<>();

        TreeNode node=root;
        if(root==null) return sc;

        s.push(node);
        while(!s.isEmpty()){
            TreeNode x=s.pop();
            t.push(x);
            if(x.left!=null){
                s.push(x.left);
            }
            if(x.right!=null){
                s.push(x.right);
            }
        }

        while(!t.isEmpty()){
            TreeNode x=t.pop();
            sc.add(x.val);
        }
       
        return sc;
    }
}