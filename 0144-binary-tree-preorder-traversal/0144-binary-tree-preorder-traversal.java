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

        if(root==null) return sc;
        TreeNode curr=root;

        while(curr!=null){
            if(curr.left==null){
                sc.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode l=curr.left;

                while(l.right!=null && l.right!=curr){
                    l=l.right;
                }

                if(l.right==null){
                    sc.add(curr.val);
                    l.right=curr;
                    curr=curr.left;
                }
                else{
                    l.right=null;
                    curr=curr.right;
                }
            }
        }

        return sc;
    }
}