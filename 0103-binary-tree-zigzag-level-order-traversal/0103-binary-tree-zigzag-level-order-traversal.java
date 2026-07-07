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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sc=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();

        if(root==null) return sc;
        q.add(new Pair(root,0));

        while(!q.isEmpty()){

            int size=q.size();
            ArrayList<Integer> l=new ArrayList<>();
            boolean even=false;

            while(size-->0){
                Pair p=q.poll();
                TreeNode m=p.x;
                int n=p.l;
                if(n%2==0){
                    even=true;
                }

                l.add(m.val);
                if(m.left!=null){
                    q.add(new Pair(m.left,n+1));
                }

                if(m.right!=null){
                    q.add(new Pair(m.right,n+1));
                }
            }
            if(!even){
                Collections.reverse(l);
                sc.add(l);
            }
            else{
                sc.add(l);
            }
        }

        return sc;
    }
}