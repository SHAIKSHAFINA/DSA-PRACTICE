class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        int [] heights=new int[n];
        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }
                else{
                    heights[j]=0;
                }
            }
             int ans=largestRectangleArea(heights);
                max=Math.max(max,ans);

        }
        return max;
    }

    int largestRectangleArea(int[] heights) {
        ArrayList<Integer> ns=nse(heights);
        ArrayList<Integer> ps=pse(heights);
        int max=0;
        int n=heights.length;
        

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
        ArrayList<Integer> sc=new ArrayList<>();

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
        ArrayList<Integer> sc=new ArrayList<>();

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