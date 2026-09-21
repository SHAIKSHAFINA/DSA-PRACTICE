class dsu{
    int size[];
    int parent[];

    dsu(int n){
        size=new int[n+1];
        parent=new int[n+1];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    int findParent(int x){
        if(x==parent[x]) return x;
        return parent[x]=findParent(parent[x]);
    }
    void unionBySize(int x,int y){
        int px=findParent(x);
        int py=findParent(y);

        if(px==py) return;

        if(size[px]<size[py]){
            size[py]+=size[px];
            parent[px]=py;
        }
        else{
            size[px]+=size[py];
            parent[py]=px;
        }

    }
}

class Solution {    
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dr[]={-1,0,1,0};
        int dc[]={0,-1,0,1};
        int max=0;

        dsu ds=new dsu(n*n);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) continue;

                for(int k=0;k<4;k++){
                    int r=dr[k]+i;
                    int c=dc[k]+j;

                    if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==1){
                        int node=i*n+j;
                        int newNode=r*n+c;
                        ds.unionBySize(node,newNode);
                    }
                }

            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> mp=new HashSet<>();

                for(int k=0;k<4;k++){
                    int r=dr[k]+i;
                    int c=dc[k]+j;

                    if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==1){
                        mp.add(ds.findParent(r*n+c));
                    }
                }
                int total=0;
                for(Integer parents:mp){
                    total+=ds.size[parents];
                }
                max=Math.max(max,total+1);

            }
        }

        for(int j=0;j<n*n;j++){
            max=Math.max(max,ds.size[ds.findParent(j)]);
        }

        return max;
    }
}