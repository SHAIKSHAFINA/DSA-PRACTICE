class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> sc=new ArrayList<>();
        k--;
        int idx=0;
        int ans=-1;
        for(int i=0;i<n;i++){
            sc.add(i+1);
        }

        return solve(k,idx,sc);
    }

    int solve(int k,int idx,ArrayList<Integer> sc){
        if(sc.size()==1){
           return sc.get(0);
        }

        idx=(idx+k) % sc.size();
        sc.remove(idx);

        return solve(k,idx,sc);
        
    }
}