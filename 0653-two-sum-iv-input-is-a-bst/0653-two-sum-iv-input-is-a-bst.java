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
    ArrayList<Integer> sc=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        solve(root);
        HashSet<Integer> mp=new HashSet<>();

        for(int i=0;i<sc.size();i++){
            int target=k-sc.get(i);
            if(mp.contains(target)){
                return true;
            }
            mp.add(sc.get(i));
        }

        return false;

    }

    void solve(TreeNode root){
        if(root==null) return;

        if(root.left!=null){
            solve(root.left);
        }

        sc.add(root.val);

        if(root.right!=null){
            solve(root.right);
        }

    }
}