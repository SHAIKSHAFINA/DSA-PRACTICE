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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int x=inorder.length;
        return order(preorder,inorder,0,x-1);
    }
    TreeNode order(int[]pre,int[] in,int s,int e){
        int j=0;
        if(s>e){
            return null;
        }
        for(int i=s;i<=e;i++){
            if(pre[preIdx]==in[i]){
                j=i;
                break;
            }
        }

        TreeNode root=new TreeNode(pre[preIdx++]);

        root.left=order(pre,in,s,j-1);
        root.right=order(pre,in,j+1,e);

        return root;
    }
}