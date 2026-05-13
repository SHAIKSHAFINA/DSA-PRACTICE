class Solution {
    public boolean parseBoolExpr(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch=='&' || ch=='|' || ch=='!'|| ch=='t'|| ch=='f'){
                st.push(ch);
            }
            else if(ch==')'){
                int t=0 , f=0;

                while(st.peek()=='t' || st.peek()=='f'){
                    char c;
                    if(st.peek()=='t'){
                        t++;
                        c=st.pop();
                    }
                    else if(st.peek()=='f'){
                        f++;
                        c=st.pop();
                    }
                }
                    if(st.peek()=='&'){
                        st.pop();
                        if(f>0){
                            st.push('f');
                        }
                        else{
                            st.push('t');
                        }
                    }
                    else if(st.peek()=='|'){
                        st.pop();
                        if(t>0){
                            st.push('t');
                        }
                        else{
                           st.push('f');
                        }
                    }
                    else if(st.peek()=='!'){
                        st.pop();
                        if(t==1){
                            st.push('f');
                        }
                        else{
                            st.push('t');
                        }
                    }
            }
        }
        return st.peek()=='t';
    }
}