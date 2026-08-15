class Solution {
    class Pair{
        int i;
        int j;

        Pair(int a,int b){
            i=a;
            j=b;
        }
    }
    public int[][] highestPeak(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int [][] a=new int[n][m];
        boolean vis[][]=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(mat[i][j]==1){
                    a[i][j]=0;
                    vis[i][j]=true;
                   q.add(new Pair(i,j));
                }

            }
        }

        bfs(mat,n,m,vis,a,q);

        return a;
    }

    void bfs(int[][] mat,int n,int m,boolean vis[][],int a[][],Queue<Pair> q){

        while(!q.isEmpty()){
                Pair p=q.poll();
                int x=p.i;
                int y=p.j;

                int dr[]={-1,1,0,0};
                int dc[]={0,0,1,-1};

                for(int k=0;k<4;k++){
                    int nr=dr[k]+x;
                    int nc=dc[k]+y;

                    if(nr>=0 && nr<n && nc>=0 && nc<m  && !vis[nr][nc]){
                        vis[nr][nc]=true;
                        a[nr][nc]=1+a[x][y];
                        q.add(new Pair(nr,nc));
                    }
                }
            
        }
        
    }
}