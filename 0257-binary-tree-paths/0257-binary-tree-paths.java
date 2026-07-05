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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> sc=new ArrayList<>();
        TreeNode curr=root;
        if(root==null) return sc;
        StringBuilder sb=new StringBuilder();

        solve(curr,sc,sb);
        return sc;

    }

    void solve(TreeNode curr,List<String> sc,StringBuilder s){
            int l=s.length();


            if(curr.left==null && curr.right==null){
                s.append(curr.val);
                sc.add(s.toString());
                s.setLength(l);
                return;
            }
            s.append(curr.val + "->");

            if(curr.left!=null){
                solve(curr.left,sc,s);
            }

            if(curr.right!=null){
                solve(curr.right,sc,s);
            }
            s.setLength(l);
    }
}