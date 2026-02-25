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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode=new TreeNode(val);
        if(root==null){
            return newNode;
        }
        TreeNode t=root;

        while(t!=null){
            if(val<t.val){
                if(t.left==null){
                    t.left=newNode;
                    break;
                }
                else{
                    t=t.left;
                }
            }
            else{
                if(t.right==null){
                    t.right=newNode;
                    break;
                }
                else{
                    t=t.right;
                }
            }
        }
        return root;
    }
}