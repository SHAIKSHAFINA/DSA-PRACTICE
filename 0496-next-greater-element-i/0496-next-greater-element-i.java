class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int ans[]=new int[n];
        HashMap<Integer,Integer> mp=new HashMap<>();
        Stack<Integer> st=new Stack<>();

        for(int x:nums2){
            while(!st.isEmpty() && st.peek() < x){
                mp.put(st.pop(),x);
            }
            st.push(x);
        }

        while(!st.isEmpty()){
            mp.put(st.pop(),-1);;
        }

        for(int i=0;i<n;i++){
            ans[i]=mp.get(nums1[i]);
        }

        return ans;
    }
}