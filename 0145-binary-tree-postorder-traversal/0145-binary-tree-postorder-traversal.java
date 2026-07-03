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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> sc=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();

        TreeNode node=root;
        if(root==null) return sc;

        while(node!=null || !s.isEmpty()){
            if(node!=null){
                s.push(node);
                node=node.left;
            }
            else{
                TreeNode x=s.peek().right;
                if(x==null){
                    x=s.pop();
                    sc.add(x.val);

                    while(!s.isEmpty() && s.peek().right==x){
                        x=s.pop();
                        sc.add(x.val);
                    }
                }
                else{
                    node=x;
                }
                
            }
        }

        return sc;
    }
}