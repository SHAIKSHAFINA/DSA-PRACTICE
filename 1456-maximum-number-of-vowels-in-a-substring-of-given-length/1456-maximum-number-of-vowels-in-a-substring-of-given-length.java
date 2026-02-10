class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int l=0,r=0,max=0,count=0;

        while(r<n){
            char c=s.charAt(r);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                count++;
            }

            while(r-l+1 > k){
                char x=s.charAt(l);
                if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u'){
                    count--;
                }
                l++;
            }
            max=Math.max(max,count);
            r++;
        }
        return max;
    }
}