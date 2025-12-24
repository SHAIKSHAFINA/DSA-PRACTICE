class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int[] arr=new int[2];
        ArrayList<Integer>a=new ArrayList<>();
        ArrayList<Integer>b=new ArrayList<>();


        int ans=0;
        for(int i=0;i<n;i++){
            ans^=nums[i];
        }

        int mask=ans & (-ans);
        for(int i=0;i<n;i++){
            if((nums[i] & mask)!=0){
                a.add(nums[i]);
            }
            else{
                b.add(nums[i]);
            }
        }
        int a1=0;
        for(int i=0;i<a.size();i++){
            a1^=a.get(i);
        }
        int a2=0;
        for(int i=0;i<b.size();i++){
            a2^=b.get(i);
        }

        arr[0]=a1;
        arr[1]=a2;
        return arr;
        

    }
}