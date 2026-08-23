class Solution {
    public boolean possibleBipartition(int n, int[][] graph) {
        int a[]=new int[n+1];
        Arrays.fill(a,-1);
        ArrayList<ArrayList<Integer>> sc=new ArrayList<>();

        for(int i=0;i<=n;i++){
            sc.add(new ArrayList<>());
        }

        for(int e[]:graph){
            int u=e[0];
            int v=e[1];

            sc.get(u).add(v);
            sc.get(v).add(u);
        }

        

        for(int i=1;i<=n;i++){
            if(a[i]==-1){
                a[i]=0;
                if(isCheck(i,sc,a)==false){
                    return false;
                }
            }
        }

        return true;
    }

    boolean isCheck(int node,ArrayList<ArrayList<Integer>> sc,int a[]){

        for(int t:sc.get(node)){
            if(a[t]==-1){
                a[t]=1-a[node];
                if(isCheck(t,sc,a)==false) return false;
            }
            else if(a[t]==a[node]){
                return false;
            }
        }

        return true;
    }
}