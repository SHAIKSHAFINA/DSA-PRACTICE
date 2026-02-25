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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode temp=null;
        if(root==null) return root;
        else if(key<root.val){
            root.left=deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else{
            if(root.left!=null && root.right!=null){
                temp=findMax(root.left);
                root.val=temp.val;
                root.left=deleteNode(root.left,root.val);
            }
            else{
                if(root.left==null){
                    root=root.right;
                }
                else if(root.right==null){
                    root=root.left;
                }
            }
        }
        return root;

    }
    TreeNode findMax(TreeNode root){

        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
}