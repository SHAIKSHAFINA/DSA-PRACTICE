class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;

        int arr[]=new int[n];

        HashMap<Integer,Integer> mp=new HashMap<>();
        ArrayList<Integer> sc=nle(nums2);

        for(int i=0;i<m;i++){
            mp.put(nums2[i],sc.get(i));
        }
        for(int i=0;i<n;i++){

            if(mp.containsKey(nums1[i])){
                arr[i]=mp.get(nums1[i]);
            }
            else{
                arr[i]=-1;
            }
            
        }

        return arr;

         
    }
    ArrayList<Integer>nle(int[]arr){
        int n=arr.length;
        ArrayList<Integer> sc=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        
        for(int i=n-1;i>=0;i--){
        
            while(!st.isEmpty() && arr[i]>=st.peek()){
                    st.pop();
            }
                
            if(st.isEmpty()){
                sc.add(-1);
            }
            else{
                sc.add(st.peek());
            }
            st.push(arr[i]);
        }
        Collections.reverse(sc);
        
        return sc;
    }
}