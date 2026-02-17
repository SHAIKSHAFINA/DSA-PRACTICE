class Solution {
    public int thirdMax(int[] nums) {
        int n=nums.length;
        Long first=null,sec=null,third=null;

        for(int i=0;i<n;i++){
            Long num=(long)nums[i];

            if ((first != null && num.equals(first)) ||
                (sec != null && num.equals(sec)) ||
                (third != null && num.equals(third))) {
                continue;
            }

            if(first == null || num > first){
                third=sec;
                sec=first;
                first=num;
            }
            else if(sec==null || num >sec){
                third=sec;
                sec=num;
            }
            else if(third==null || num >third){
                third=num;
            }
        }
        return third == null ? first.intValue() : third.intValue();
    }
}