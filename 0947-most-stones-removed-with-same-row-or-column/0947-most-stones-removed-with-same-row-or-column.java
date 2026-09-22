class dsu{
    int parent[];
    int size[];

    dsu(int n){
        parent=new int[n+1];
        size=new int[n+1];


        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }


    int findParent(int x){
        if(x==parent[x]) return x;
        return parent[x]=findParent(parent[x]);
    }


    void UnionBySize(int u,int v){
        int pu=findParent(u);
        int pv=findParent(v);


        if(pu==pv) return;


        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }
        else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int s[][]=new int[n][n];
        dsu ds=new dsu(n*n);

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    ds.UnionBySize(i,j);
                }
            }
        }
        
        HashSet<Integer> mp=new HashSet<>();

        for(int i=0;i<n;i++){
            mp.add(ds.findParent(i));
        }

        return n-mp.size();
    }
}