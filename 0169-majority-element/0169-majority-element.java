class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int c=0,can=0;
        for(int i=0;i<n;i++){
            if(c==0){
                can=nums[i];
            }
           if(can==nums[i]){
            c++;
           }
           else{
            c--;
           }
        }
        return can;
    }
}