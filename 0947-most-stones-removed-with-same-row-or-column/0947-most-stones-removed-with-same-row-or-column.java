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
        int offset=10001;
        dsu ds=new dsu(20002);

        for(int e[]:stones){
            int row=e[0];
            int col=e[1]+offset;
            ds.UnionBySize(row,col);
        }
        
        HashSet<Integer> mp=new HashSet<>();

        for(int e[]:stones){
            int row=e[0];
            mp.add(ds.findParent(row));
        }

        return n-mp.size();
    }
}