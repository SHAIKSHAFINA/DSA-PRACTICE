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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans=new ArrayList<>();
        HashMap<String,Integer> mp=new HashMap<>();
        int n=accounts.size();

        dsu ds=new dsu(n);

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!mp.containsKey(mail)){
                    mp.put(mail,i);
                }
                else{
                    ds.UnionBySize(i,mp.get(mail));
                }
            }
        }

        ArrayList<String>[] merge=new ArrayList[n];

        for(int i=0;i<n;i++){
            merge[i]=new ArrayList<String>();
        }

        for(Map.Entry<String,Integer> it:mp.entrySet()){
            String mail=it.getKey();
            int node=ds.findParent(it.getValue());
            merge[node].add(mail);
        }

        for(int i=0;i<n;i++){
            if(merge[i].size()==0) continue;
            Collections.sort(merge[i]);

            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:merge[i]){
                temp.add(it);
            }
            ans.add(temp);

        }

        return ans;
    }
}