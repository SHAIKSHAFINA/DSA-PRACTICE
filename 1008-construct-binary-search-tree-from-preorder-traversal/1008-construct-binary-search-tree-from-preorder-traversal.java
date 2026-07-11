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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        return solve(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    
    }

    TreeNode  solve(int [] preorder,int min,int max){
        if(i>=preorder.length) return null;
        if(preorder[i]<min || preorder[i]>max){
            return null;
        }
        TreeNode node=new TreeNode(preorder[i++]);
        node.left= solve(preorder,min,node.val);
        node.right= solve(preorder,node.val,max);
        return node;
    }
}