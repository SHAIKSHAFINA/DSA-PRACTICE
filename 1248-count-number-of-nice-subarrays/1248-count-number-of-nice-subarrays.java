class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       int n=nums.length;
       int c=0,ps=0;
       HashMap<Integer,Integer>mp=new HashMap<>();
       mp.put(0,1);

        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }
            else{
                nums[i]=1;
            }
            ps+=nums[i];
            int s=ps-k;
            c+=mp.getOrDefault(s,0);
            mp.put(ps,mp.getOrDefault(ps,0)+1);

       } 
       return c;
    }
}