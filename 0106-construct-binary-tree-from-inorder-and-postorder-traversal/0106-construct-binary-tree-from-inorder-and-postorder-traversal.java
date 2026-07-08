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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int x=inorder.length;
        postIdx = postorder.length - 1;
        return order(inorder,postorder,0,x-1);
    }
    TreeNode order(int[] in,int[]post,int s,int e){
        int j=0;
        if(s>e){
            return null;
        }
        for(int i=s;i<=e;i++){
            if(post[postIdx]==in[i]){
                j=i;
                break;
            }
        }

        TreeNode root=new TreeNode(post[postIdx--]);

        root.right=order(in,post,j+1,e);
        root.left=order(in,post,s,j-1);

        return root;
    }
}