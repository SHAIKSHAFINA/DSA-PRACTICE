class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> sc=new ArrayList<>();

        for(int i=1;i<n;i++){
            fact*=i;
            sc.add(i);
        }
        sc.add(n);

        String ans="";
        k-=1;
        while(true){
            ans=ans+sc.get(k/fact);
            sc.remove(k/fact);

            if(sc.size()==0){
                break;
            }

            k=k%fact;
            fact=fact / sc.size();
        }

        return ans;
    }
}