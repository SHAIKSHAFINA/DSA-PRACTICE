class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> sc=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int k=i+1;
            int j=n-1;
            while(k<j){
                int t=nums[i]+nums[j]+nums[k];

                if(t==0){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    
                    sc.add(l);

                    k++;
                    j--;

                    while(k<j && nums[k]==nums[k-1]) k++;

                    while(k<j && nums[j]==nums[j+1]) j--;
                }
                else if(t>0){
                    j--;
                }
                else{
                    k++;
                }
            }

        }
        return sc;

    }
}