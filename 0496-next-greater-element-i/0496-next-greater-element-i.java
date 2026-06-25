class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int [] a=new int[n];
        Arrays.fill(a,-1);


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i]==nums2[j]){
                    for(int k=j+1;k<m;k++){
                       if(nums2[j]< nums2[k]){
                            a[i]=nums2[k];
                            break;
                        } 
                    }
                }
            }
        }

        return a;
    }
}