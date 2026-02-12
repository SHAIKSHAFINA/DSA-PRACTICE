class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArray(nums,k)-subArray(nums,k-1);
    }
    int subArray(int[] arr,int k){
        int n=arr.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int l=0,r=0,c=0;

        while(r<n){
            mp.put(arr[r],mp.getOrDefault(arr[r],0)+1);
            while(mp.size()>k){
                mp.put(arr[l],mp.get(arr[l])-1);
                if(mp.get(arr[l])==0){
                    mp.remove(arr[l]);
                }
                l++;
            }
            c+=r-l+1;
            r++;
        }
        return c;
    }
}