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
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return sc;
        q.add(root);

        while(!q.isEmpty()){
            int n=q.size();
            TreeNode x=null;
            while(n-->0){
                x=q.poll();
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
            }
            sc.add(x.val);
        }

        return sc;
    }
}