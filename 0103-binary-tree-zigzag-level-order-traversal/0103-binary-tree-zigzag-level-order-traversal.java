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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> sc=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return sc;
        q.add(root);
        int level=0;

        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>l=new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode x=q.poll();
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right!=null){
                    q.add(x.right);
                }
                l.add(x.val);

            }
            if(level%2==0){
                sc.add(l);
            }
            else{
                Collections.reverse(l);
                sc.add(l);
            }
            level++;
            
        }
        return sc;
    }
   
}