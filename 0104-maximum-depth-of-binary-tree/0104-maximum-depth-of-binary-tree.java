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
    class Pair{
        TreeNode x;
        int l;
        Pair(TreeNode a,int b){
            x=a;
            l=b;
        }
    }
    public int maxDepth(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();

        if(root==null) return 0;
        q.add(new Pair(root,0));
        int c=0;

        while(!q.isEmpty()){

            int size=q.size();
            c++;

            while(size-->0){
                Pair p=q.poll();
                TreeNode m=p.x;
                int n=p.l;

                if(m.left!=null){
                    q.add(new Pair(m.left,n+1));
                }

                if(m.right!=null){
                    q.add(new Pair(m.right,n+1));
                }
            }
        }

        return c;
    }
}