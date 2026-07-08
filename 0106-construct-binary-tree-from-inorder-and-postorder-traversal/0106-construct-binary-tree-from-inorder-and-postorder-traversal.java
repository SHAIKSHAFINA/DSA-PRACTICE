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
    int postIdx = 0;
    Map<Integer,Integer> mp=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int x=inorder.length;
        postIdx = postorder.length - 1;

        for(int i=0;i<x;i++){
            mp.put(inorder[i],i);
        }
        return order(inorder,postorder,0,x-1);
    }
    TreeNode order(int[] in,int[]post,int s,int e){

        if(s>e){
            return null;
        }
        int NodeVal=post[postIdx--];
        TreeNode root=new TreeNode(NodeVal);
        int j=mp.get(NodeVal);

        root.right=order(in,post,j+1,e);
        root.left=order(in,post,s,j-1);

        return root;
    }
}