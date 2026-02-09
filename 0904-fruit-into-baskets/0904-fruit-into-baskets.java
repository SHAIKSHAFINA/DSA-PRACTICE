class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        HashMap<Integer,Integer> mp=new HashMap<>();

        int l=0,r=0,max=0,c=0;
        while(r<n){
            int x=fruits[r];
            if(mp.getOrDefault(fruits[r],0)==0){
                c++;
            }
            mp.put(x,mp.getOrDefault(x,0)+1);

            while(c>2){
                mp.put(fruits[l],mp.get(fruits[l])-1);
                 if(mp.get(fruits[l])==0){
                    c--;
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
        
    }
}