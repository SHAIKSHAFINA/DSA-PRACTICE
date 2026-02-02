class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayList<Integer> ns=nse(heights);
        ArrayList<Integer> ps=pse(heights);
        int max=0;
        int n=heights.length;
        if(n==1) return heights[0];

        for(int i=0;i<n;i++){
            int left=ps.get(i);
            int right=ns.get(i);
            int ans=(right-left-1) * heights[i];
            max=Math.max(max,ans);

        }
        return max;
    }

    ArrayList<Integer> nse(int[]a){
        int n=a.length;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer>sc=new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                sc.add(n);
            }
            else{
                sc.add(st.peek());
            }
            st.push(i);
        }
        Collections.reverse(sc);
        return sc;
    }

     ArrayList<Integer> pse(int[]a){
        int n=a.length;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer>sc=new ArrayList<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                sc.add(-1);
            }
            else{
                sc.add(st.peek());
            }
            st.push(i);
        }
        return sc;
    }
}