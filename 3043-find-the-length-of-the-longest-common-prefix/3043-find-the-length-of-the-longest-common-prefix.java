class TrieNode{
        TrieNode child[];
        boolean isEnd;

        TrieNode(){
            child=new TrieNode[10];
            isEnd=false;
        }
    }
    
    class Solution {
        TrieNode root=new TrieNode();

        // TrieNode getTrieNode(){
        //     TrieNode node=new TrieNode();
        //     // for(int i=0;i<10;i++){
        //     //     node.child[i]=null;
        //     // }

        //     return node;
        // }
        public void insert(int num , TrieNode root){
            TrieNode crawl=root;
            String s=Integer.toString(num);

            for(char ch:s.toCharArray()){
                int idx=ch-'0';

                if(crawl.child[idx]==null){
                    crawl.child[idx]=new TrieNode();
                }

                crawl=crawl.child[idx];

            }

            crawl.isEnd=true;
        }

        int search(int num,TrieNode root){
            TrieNode crawl=root;
            String s=Integer.toString(num);
            int length=0;

            for(char ch:s.toCharArray()){
                int idx=ch-'0';
                if(crawl.child[idx]!=null){
                    length++;
                    crawl=crawl.child[idx];
                }
                else{
                    break;
                }

            }

            return length;
        }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        //TrieNode root=getTrieNode();

        for(int num:arr1){
            insert(num,root);
        }
        int res=0;

        for(int num:arr2){
            res=Math.max(res,search(num,root));
        }

        return res;
    }
}