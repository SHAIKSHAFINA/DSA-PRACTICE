/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> pq=new LinkedList();
        pq.offer(root);

        while(!pq.isEmpty()){
                TreeNode x=pq.poll();
                if(x==null){
                    sb.append("N ");
                    continue;
                }
                sb.append(x.val+" ");
                pq.offer(x.left);
                pq.offer(x.right);
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
                return null;
        }

        String a[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(a[0]));
        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);
        int i=1;

        while(!q.isEmpty() && i<a.length){
            TreeNode x=q.poll();
            if(!a[i].equals("N")){
                TreeNode l=new TreeNode(Integer.parseInt(a[i]));
                x.left=l;
                q.add(l);
            }

            i++;
            if(i >=a.length) break;
             if(!a[i].equals("N")){
               TreeNode r=new TreeNode(Integer.parseInt(a[i]));
                x.right=r;
                q.add(r);
            }

             i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));