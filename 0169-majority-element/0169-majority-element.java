class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int c=0,can=nums[0],l=0;
        for(int i=1;i<n;i++){
           if(can==nums[l]){
                c++;
           }
           else{
            c--;
           }
            if(c==0){
                can=nums[i];
            }
            l++;
        }
        return can;
    }
}