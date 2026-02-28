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
    static class Pair{
    TreeNode node;
    int vertical;
    int level;

    Pair(TreeNode n,int v,int l){
        node=n;
        vertical=v;
        level=l;
    }
}
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer ,TreeMap<Integer,PriorityQueue<Integer>>> mp=new TreeMap<>();

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));

        while(!q.isEmpty()){
            Pair p= q.poll();
            TreeNode temp=p.node;
            int x=p.vertical;
            int y=p.level;

            mp.putIfAbsent(x,new TreeMap<>());
            mp.get(x).putIfAbsent(y,new PriorityQueue<>());
            mp.get(x).get(y).offer(temp.val);

            if(temp.left!=null){
                q.offer(new Pair(temp.left,x-1,y+1));
            }

            if(temp.right!=null){
                q.offer(new Pair(temp.right,x+1,y+1));
            }
         }

         List<List<Integer>> res=new ArrayList<>();

         for(TreeMap<Integer, PriorityQueue<Integer>> rows:mp.values()){
            List<Integer> col=new ArrayList<>();

            for(PriorityQueue<Integer> val:rows.values()){
                while(!val.isEmpty()){
                    col.add(val.poll());
                }
            }
            res.add(col);
         }
         return res;
    }
}

