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

 class BSTIterator {
    Stack<TreeNode> st=new Stack<>();
    boolean reverse=true;

    public BSTIterator(TreeNode root , boolean isReverse) {
        reverse=isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode temp=st.pop();
        if(reverse){
            pushAll(temp.left);
        }
        else{
            pushAll(temp.right);
        }
        return temp.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse){
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);

        int i=l.next();
        int j=r.next();

        while(i<j){
            int t=i+j;
            if(t==k) return true;
            if(t>k){
                j=r.next();
            }
            else{
                i=l.next();
            }
        }

        return false;
    }
}