class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

       List<List<Integer>> adj=new ArrayList<>(); 

       for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
       }

       for(int p[] : paths){
        int u=p[0];
        int v=p[1];
        adj.get(u).add(v);
        adj.get(v).add(u);

       }

       int ans[]=new int[n+1];
      
       for(int i=1;i<=n;i++){
            boolean used[]=new boolean[5];
            for(int nei:adj.get(i)){
                used[ans[nei]]=true;
            }
            for(int c=1;c<=4;c++){
                if(!used[c]){
                    ans[i]=c;
                    break;
                }
       }
       }

       return Arrays.copyOfRange(ans,1,n+1);
    }
    
}