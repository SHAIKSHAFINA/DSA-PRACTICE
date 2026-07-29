class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[]next=nse(heights,n);
        int[]prev=nge(heights,n);
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int width=prev[i]-next[i]-1;
            int area=width*heights[i];
            max=Math.max(max,area);
        }
        return max;
    }

    int[] nse(int arr[],int n){
        Stack<Integer> st=new Stack<>();
        int a[]=new int [n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                a[i]=st.peek();
            }
            else{
                a[i]=-1;
            }
            st.push(i);
        }
        return a;
    }

    int[] nge(int arr[],int n){
        Stack<Integer> st=new Stack<>();
        int a[]=new int [n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
    
            if(!st.isEmpty()){
                a[i]=st.peek();
            }
            else{
                a[i]=n;
            }
            st.push(i);
        }
        return a;
    }
}