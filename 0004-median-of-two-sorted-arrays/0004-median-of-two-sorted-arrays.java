class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int l=0,r=0;
        int i=0;
        int e1=-1;
        int e2=-1;
        int x=(n+m)/2;

        while(l<=n-1 && r<=m-1){
            if(nums1[l]<=nums2[r]){
                if(i==x){
                    e1=nums1[l];
                }
                if(i==(x-1)){
                    e2=nums1[l];
                }
                l++;
            }
            else{
                if(i==x){
                    e1=nums2[r];
                }
                if(i==(x-1)){
                    e2=nums2[r];
                }
                r++;
            }
            i++;
        }

        while(l<=n-1){
           if(i==x){
                e1=nums1[l];
            }
            if(i==(x-1)){
                e2=nums1[l];
            }
            l++;
            i++;
        }

        while(r<=m-1){
            if(i==x){
                e1=nums2[r];
            }
            if(i==(x-1)){
                e2=nums2[r];
            }
            r++;
            i++;
        }

        if((n+m)%2==0){
            return (e1+e2)/ 2.0;
        }
        else{
            return  e1;
        }
    }
}