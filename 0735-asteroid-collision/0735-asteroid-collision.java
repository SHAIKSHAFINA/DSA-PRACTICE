class Solution {
    public int[] asteroidCollision(int[] a) {
        int n=a.length;
       
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            boolean des=false;
            while(!st.isEmpty() && a[i]<0 && st.peek()>0 && Math.abs(a[i]) >st.peek()){
                st.pop();
            }
            
            if(!st.isEmpty() && st.peek()>0 && a[i]<0){
                if(st.peek() == Math.abs(a[i])){
                    st.pop();
                }
                des=true;
            }

            if(des==false){
                st.push(a[i]);
            }
        }
        int i=st.size()-1;
         int arr[]=new int[st.size()];
        while(!st.isEmpty()){
            arr[i--]=st.pop();
        }
        return arr;
    }
}