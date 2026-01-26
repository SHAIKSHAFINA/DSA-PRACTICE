class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1000000007;
        int total=0;
        ArrayList<Integer>nse=findNse(arr);
        ArrayList<Integer>pse=findPse(arr);

        for(int i=0;i<n;i++){
            int left=i-pse.get(i);
            int right=nse.get(i)-i;
            long freq= left*right*1L;
            int val= (int)((freq * arr[i])%mod);
            total= (total+val)%mod;
        }
        return total;
    }
    ArrayList<Integer> findNse(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> sc=new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
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

    ArrayList<Integer> findPse(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> sc=new ArrayList<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
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