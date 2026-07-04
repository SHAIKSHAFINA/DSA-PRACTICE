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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sc=new ArrayList<>();
        order(root,sc,0);
        return sc;

    }

    void order(TreeNode root,List<Integer>sc,int l){
        if(root==null) return;
        if(sc.size()==l){
            sc.add(root.val);
        }
        order(root.right,sc,l+1);
        order(root.left,sc,l+1);
    }
}