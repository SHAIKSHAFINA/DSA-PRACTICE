class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int a[]=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                a[i]=st.peek();
            }
            else{
                a[i]=-1;
            }
            st.push(nums[i]);
        }

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                a[i]=st.peek();
            }
            else{
                a[i]=-1;
            }
            
            st.push(nums[i]);
        }
        return a;
    }
}