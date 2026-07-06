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
        List<List<Integer>> sc=new ArrayList<>();
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

        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> e:mp.entrySet()){
            List<Integer> l=new ArrayList<>();
            for(Map.Entry<Integer, PriorityQueue<Integer>> level:e.getValue().entrySet()){
                PriorityQueue<Integer> pq = level.getValue();
                while(!pq.isEmpty()){
                    
                    l.add( pq.poll());
                }
            }
            sc.add(l);
        }     

        return sc; 
    }
}

