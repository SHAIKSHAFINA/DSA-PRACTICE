class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        if(n>m) return findMedianSortedArrays(nums2,nums1);

        int l=0,r=n;
        int n1=(n+m+1)/2;

        while(l<=r){
            int p=l+(r-l)/2;
            int q=n1-p;

             int l1=(p==0)?Integer.MIN_VALUE :  nums1[p-1];
             int l2=(q==0)?Integer.MIN_VALUE : nums2[q-1];
             int r1=(p==n)?Integer.MAX_VALUE : nums1[p];
             int r2=(q==m)?Integer.MAX_VALUE : nums2[q];

            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2)) / 2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
            else if(l1>r2){
                r=p-1;
            }
            else{
                l=p+1;
            }
        }
        return -1;

    }
}