class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        if(n%2!=0) return false;

       for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }
            else if(!st.isEmpty()){
                if(c==')' && st.peek()=='('){
                    st.pop();
                }
                else if(c=='}' && st.peek()=='{'){
                        st.pop();
                 }
                else if(c==']' && st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
                else {
                    return false;
                }
        }
        if(st.size()==0) return true;
        return false;
    }
}