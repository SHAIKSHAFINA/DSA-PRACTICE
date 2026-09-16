class dsu{
    int parent[];
    int rank[];
    int size[];

    dsu(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        size=new int[n+1];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
            size[i]=1;
        }
    }

    int findParent(int node){
        if(node==parent[node]) return node;
        return parent[node]=findParent(parent[node]);
    }

    void unionBySize(int u,int v){
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
    public int makeConnected(int n, int[][] connections) {
        dsu ds=new dsu(n);
        int c=0;
        int total=n;
        
        for(int e[]:connections){
            int u=e[0];
            int v=e[1];

            if(ds.findParent(u)!=ds.findParent(v)){
                total--;
                ds.unionBySize(u,v);
            }
            else if(ds.findParent(u)==ds.findParent(v)){
                c++;
            }
            
        }

        int req=total-1;
        
        if(c>=req) return req;
        else return -1;
    }
}