class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> sc= new ArrayList<>();
        int z=nums.length;
        int c1=0,c2=0,can1=0,can2=0;
        for(int n:nums){
            if(can1==n){
                c1++;
            }
            else if(can2==n){
                c2++;
            }
             else if(c1==0){
                can1=n;
                c1=1;
            }
            else if(c2==0){
                can2=n;
                c2=1;
            }
            else{
                c1--;
                c2--;
            }
            
        }
        int count1=0,count2=0;
        for(int x:nums){
            if(x==can1){
                count1++;
            }
            else if(x==can2){
                count2++;
            }
        }
        if(count1>(z/3)){
            sc.add(can1);
        }
         if(count2>(z/3)){
            sc.add(can2);
        }
        return sc;
    }
}