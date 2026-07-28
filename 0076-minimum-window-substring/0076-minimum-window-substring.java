class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> f=new HashMap<>();

        for(char c:t.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        int l=0,r=0,c=0,freq=mp.size(),min=Integer.MAX_VALUE;

        int st=0,e=0;
        boolean found=false;

        while(r<m){
            char ch=s.charAt(r);
            if(mp.containsKey(ch)){

                f.put(ch,f.getOrDefault(ch,0)+1);
                if(f.get(ch).intValue()==mp.get(ch).intValue()){
                    c++;
                }
            }

            while(c==freq){
                if(r-l+1<min){
                    st=l;
                    e=r;
                    min=Math.min(min,r-l+1);
                    found=true;
                }
                char x=s.charAt(l);
                if(mp.containsKey(x)){
                    f.put(x,f.getOrDefault(x,0)-1);
                    if(f.get(x)<mp.get(x)){
                        c--;
                    }
                    if(f.get(x)==0){
                        f.remove(x);
                    }
             }
                l++;
                
            }
            r++;
        }

        if(found) return s.substring(st,e+1);

        return "";

    }
}