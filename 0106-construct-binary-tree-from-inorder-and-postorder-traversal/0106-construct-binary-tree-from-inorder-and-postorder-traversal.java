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
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        int x=inorder.length;
        preIdx = preorder.length - 1;
        return order(inorder,preorder,0,x-1);
    }
    TreeNode order(int[] in,int[]pre,int s,int e){
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

        TreeNode root=new TreeNode(pre[preIdx--]);

        root.right=order(in,pre,j+1,e);
        root.left=order(in,pre,s,j-1);

        return root;
    }
}