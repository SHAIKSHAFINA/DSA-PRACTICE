class Solution {
    public int findTheCity(int m, int[][] edges, int distanceThreshold) {
        int inf=100000000;
        int dist[][]=new int[m][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                    dist[i][j]=0;
                }
                else{
                    dist[i][j]=inf;
                }
            }
            
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            dist[u][v]=w;
            dist[v][u]=w;
        }

        for(int k=0;k<m;k++){
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    
                    if(dist[i][k]!=inf && dist[k][j]!=inf){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int ans=0,min=Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            int c=0;
            for(int j=0;j<m;j++){
                if(i!=j && dist[i][j]<=distanceThreshold){
                    c++;
                }
            }
             if(c<=min){
                min=c;
                ans=i;
            }
        }

        return ans;
    }
}