class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        Stack<Integer> st=new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i%n]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                arr[i%n]=-1;
            }
            else{
                arr[i%n]=st.peek();
            }
            st.push(nums[i%n]);
        }

       
        return arr;

    }
}