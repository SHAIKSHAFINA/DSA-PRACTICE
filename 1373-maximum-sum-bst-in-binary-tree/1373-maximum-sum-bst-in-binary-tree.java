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
class NodeValue{
    public int min,max,sum;

    NodeValue(int m,int n,int s){
        min=m;
        max=n;
        sum=s;
    }
}
class Solution {
    int ans=0;
    private NodeValue BST(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }

        NodeValue left=BST(root.left);
        NodeValue right=BST(root.right);

        if(left.max < root.val && root.val< right.min){
             int currSum = left.sum + right.sum + root.val;
            ans = Math.max(ans, currSum);
            return new NodeValue(Math.min(root.val,left.min),Math.max(root.val,right.max),currSum);
        }

        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
    }
    public int maxSumBST(TreeNode root) {
        BST(root);
        return ans;
    }
}