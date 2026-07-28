class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int l=0,r=0,max=0;
        HashMap<Integer,Integer> mp=new HashMap<>();

        while(r<n){
            int x=fruits[r];
            mp.put(x,mp.getOrDefault(x,0)+1);

            if(mp.size()>2){
                int y=fruits[l];
                mp.put(y,mp.getOrDefault(y,0)-1);
                if(mp.get(y)==0){
                    mp.remove(y);
                }
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }

        return max;
    }
}