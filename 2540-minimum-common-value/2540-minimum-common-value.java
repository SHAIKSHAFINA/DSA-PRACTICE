class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int max=Math.max(n,m);
        if(nums1[n-1]<nums2[0] || nums2[m-1] < nums1[0]){
            return -1;
        }

        int l=0,r=0;
        while(l<n && r<m){
            if(nums1[l]<nums2[r]){
                l++;
            }

            else if(nums1[l]>nums2[r]){
                r++;
            }
            else{
                return nums1[l];
            }
        }

        return -1;
    }
}