class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long total=0;
        ArrayList<Integer>nse=findNse(nums);
        ArrayList<Integer>pse=findPse(nums);
        ArrayList<Integer>nge=findNge(nums);
        ArrayList<Integer>pge=findPge(nums);


        for(int i=0;i<n;i++){
            int left1=i-pse.get(i);
            int right1=nse.get(i)-i;
            int left2=i-pge.get(i);
            int right2=nge.get(i)-i;
            long freq1= left1*right1*1L;
            long freq2= left2*right2*1L;
            long val= (freq2* nums[i])-(freq1* nums[i]);
            total= (total+val);
        }
        return total;
    }
    ArrayList<Integer> findNse(int [] nums){
        int n=nums.length;
        ArrayList<Integer> sc=new ArrayList<>();
        Stack<Integer> st=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
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

    ArrayList<Integer> findNge(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> sc=new ArrayList<>();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
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

    ArrayList<Integer> findPge(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> sc=new ArrayList<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]>arr[st.peek()]){
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