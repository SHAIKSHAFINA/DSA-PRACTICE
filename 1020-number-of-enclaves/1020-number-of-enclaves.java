class Solution {
    class Pair{
        int i;
        int j;

        Pair(int a,int b){
            i=a;
            j=b;
        }
    }
    public int numEnclaves(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        int c=0;
        boolean vis[][]=new boolean[n][m];

        Queue<Pair> q=new LinkedList<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if((i==0 || i==n-1 || j==0 || j==m-1) && board[i][j]==1){
                vis[i][j]=true;
                board[i][j]=0;
                q.add(new Pair(i,j));
            }
        }
       }

            while(!q.isEmpty()){
                Pair p=q.poll();
                int x=p.i;
                int y=p.j;

                        
                int dr[]={-1,1,0,0};
                int dc[]={0,0,-1,1};

                    for(int k=0;k<4;k++){
                        int nr=dr[k]+x;
                        int nc=dc[k]+y;

                        if(nr<0 || nr>=n || nc<0 || nc>=m) continue;

                        if(board[nr][nc]==1 && !vis[nr][nc]){
                            board[nr][nc]=0;
                             vis[nr][nc]=true;
                            q.add(new Pair(nr,nc));
                        }
                    }
            }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(board[i][j]==1){
                    c++;
               }
            }
        }
       
        return c; 
    }
}