class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        swap(0,n-1,s);
        return;
    }

    void swap(int i,int j,char[] s){
        if(i>s.length/2) return;
        while(i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}