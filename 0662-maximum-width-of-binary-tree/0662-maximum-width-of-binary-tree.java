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
        long y;
        Pair(TreeNode a,long b){
            x=a;
            y=b;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        //TreeNode curr=root;
        q.add(new Pair(root,1));
        long max=Long.MIN_VALUE;

        while(!q.isEmpty()){
            int size=q.size();
            long f=0,l=0;

            for(int d=0;d<size;d++){
                Pair p=q.poll();
                if(d==0){
                    f=p.y;
                }
                if(d==(size-1)){
                    l=p.y;
                }
                TreeNode i=p.x;
                long j=p.y;

                if(i.left!=null){
                    q.add(new Pair(i.left,(long)2*j-1));
                }

                if(i.right!=null){
                    q.add(new Pair(i.right,2*j));
                }
            }
           
             max=Math.max(max,l-f+1);
        }
        return (int)max;
    }
}