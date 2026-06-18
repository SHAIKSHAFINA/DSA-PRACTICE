class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();

        solve(nums,0,l);
        return l;
    }

    void solve(int nums[],int start,List<List<Integer>> res){
        int n=nums.length;
        if(start==n){
            List<Integer> sc=new ArrayList<>();
            for(int x:nums){
                sc.add(x);
            }
            res.add(sc);
            return;
        }

        for(int i=start;i<n;i++){
            swap(nums,start,i);
            solve(nums,start+1,res);
            swap(nums,start,i);
        }
        return;

    }

    void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}