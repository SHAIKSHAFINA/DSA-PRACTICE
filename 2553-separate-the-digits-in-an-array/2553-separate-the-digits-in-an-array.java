class Solution {
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> sc=new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            int num=nums[i];
            
            while(num>0){
                int d=num%10;
                sc.add(d);
                num/=10;
            }
    
        }
        Collections.reverse(sc);

        int a[]=new int[sc.size()];
        for(int i=0;i<sc.size();i++){
            a[i]=sc.get(i);
        }
        return a;
    }
}