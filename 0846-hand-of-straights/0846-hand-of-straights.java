class Solution {
    public boolean isNStraightHand(int[] arr, int k) {
        int n=arr.length;
        if(n%k!=0) return false;
        TreeMap<Integer,Integer> mp=new TreeMap<>();

        for(int num:arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        while(!mp.isEmpty()){
            int min=mp.firstKey();
            for(int i=0;i<k;i++){
                int curr=min+i;
                if(!mp.containsKey(curr)){
                    return false;
                }
            
            mp.put(curr,mp.get(curr)-1);
            if(mp.get(curr)==0){
                mp.remove(curr);
            }
            }
            
        }
       

        

        return true;
    }
}