class Solution {
    List<List<String>>ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // code here
        
        List<List<String>> sc=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            List<String> row=new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add("0");
            }
            sc.add(row);
        }
        boolean row[]=new boolean[n];
        boolean dia[]=new boolean[2*n-1];
        boolean antiDia[]=new boolean[2*n-1];
        
        List<String> temp=new ArrayList<>();
        
        solve(sc,temp,n,0,row,dia,antiDia);
        return ans;
        
    }
    
    void solve(List<List<String>>sc,List<String> temp,int n,int j, boolean [] row , boolean []dia, boolean [] antiDia){
        
        if(j==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!row[i] && !dia[i+j] && !antiDia[i-j+n-1]){
                sc.get(i).set(j,"1");
                char [] r=new char[n];
                Arrays.fill(r,'.');
                r[i]='Q';
                temp.add(new String(r));
                
                row[i]=true;
                dia[i+j]=true;
                antiDia[i-j+n-1]=true;
                
                solve(sc,temp,n,j+1,row,dia,antiDia);
                
                temp.remove(temp.size()-1);
                sc.get(i).set(j,"0");
                
                row[i]=false;
                dia[i+j]=false;
                antiDia[i-j+n-1]=false;
            }
        }
        
        return;
        
    }
}