class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int[] arr=new int[2];

        int ans=0;
        for(int i=0;i<n;i++){
            ans^=nums[i];
        }

        int mask=ans & (-ans) , a1=0 ,a2=0;
        for(int i=0;i<n;i++){
            if((nums[i] & mask)!=0){
                a1^=nums[i];
            }
            else{
                a2^=nums[i];
            }
        }
        arr[0]=a1;
        arr[1]=a2;
        return arr;
        

    }
}