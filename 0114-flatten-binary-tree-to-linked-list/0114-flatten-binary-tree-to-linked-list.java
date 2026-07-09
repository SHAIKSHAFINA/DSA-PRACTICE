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
    Queue<TreeNode> q=new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root==null) return;
        solve(root);
        if(q.size()==1) return;
        while(!q.isEmpty()){
            root.right=q.poll();
            root=root.right;
            root.left=null;
        }
    }

    void solve(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left==null){
                q.add(curr);
                curr=curr.right;
            }
            else{
                TreeNode l=curr.left;

                while(l.right!=null && l.right!=curr){
                   l=l.right;
                }

                if(l.right==null){
                    q.add(curr);
                    l.right=curr;
                    curr=curr.left;
                }
                else{
                    l.right=null;
                    curr=curr.right;
                }
            }
        }

       
    }
}