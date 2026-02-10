class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> sc=new ArrayList<>();
        int n=nums.length;
        int c1=0,c2=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]<target){
                c1++;
            }
            else if(nums[i]==target){
                c2++;
            }
        }
        for(int i=0;i<c2;i++){
            sc.add(c1+i);
        }
               
         return sc;
    }
}