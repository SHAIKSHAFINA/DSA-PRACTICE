class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int c=0,can=0;
        for(int num:nums){
            if(c==0){
                can=num;
            }
           if(can==num){
            c++;
           }
           else{
            c--;
           }
        }
        return can;
    }
}