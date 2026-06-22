class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int l=0,r=0;
        int [] k=new int[n+m];
        int i=0;

        while(l<=n-1 && r<=m-1){
            if(nums1[l]<=nums2[r]){
                k[i]=nums1[l];
                l++;
            }
            else{
                k[i]=nums2[r];
                r++;
            }
            i++;
        }

        while(l<=n-1){
            k[i]=nums1[l];
            l++;
            i++;
        }

        while(r<=m-1){
            k[i]=nums2[r];
            r++;
            i++;
        }

        if((n+m)%2==0){
            return (k[(n+m)/2]+k[((n+m)/2) -1]) / 2.0;
        }
        else{
            return  k[(n+m)/2];
        }
    }
}