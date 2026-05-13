class Solution {
    public boolean isScramble(String a, String b) {
        int n=a.length();
        int m=b.length();
        if(m!=n) return false;
        HashMap<String,Boolean> mp=new HashMap<>();
        return solve(a,b,mp);
    }
    
    static boolean solve(String a,String b,HashMap<String,Boolean> mp){
        int n=a.length();
        int m=b.length();
        
        if(n!=m) return false;
        if(n==0 && m==0) return true;
        if(a.equals(b)) return true;
        boolean ans1=false;
        boolean ans2=false;
        
        String key=a+" "+b;
        if(mp.containsKey(key)){
            return mp.get(key);
        }

        int freq[]=new int[26];
        
        for(int i=0;i<n;i++){
            freq[a.charAt(i)-'a']++;
            freq[b.charAt(i)-'a']--;
        }
        
        for(int f:freq){
            if(f!=0){
                mp.put(key,false);
                return false;
            }
        }

        for(int i=1;i<=n-1;i++){
            if(solve(a.substring(0,i),b.substring(n-i,n),mp) &&
                solve(a.substring(i,n),b.substring(0,n-i),mp)){
                    ans1=true;
            }
            
            if(solve(a.substring(0,i),b.substring(0,i),mp) &&
                solve(a.substring(i,n),b.substring(i,n),mp)){
                    ans2=true;
                     mp.put(key,ans2);
            }
        }
         boolean ans=ans1|| ans2;
         if(ans==true){
            mp.put(key,true);
            return true;
         }
         mp.put(key,ans);
         return ans;
    }
}
