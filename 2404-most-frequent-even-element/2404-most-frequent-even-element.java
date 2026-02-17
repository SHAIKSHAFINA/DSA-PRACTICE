class Solution {
    public int mostFrequentEven(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            }
        }
        int maxFreq=-1 ,ans=-1;

        for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            int val=entry.getValue();
            int key=entry.getKey();
            if(val>maxFreq){
                maxFreq=val;
                ans=key;
            }
            if(val==maxFreq && key<ans){
                ans=key;
            }
        }

        return ans;

    }
}