class Solution {
    public String minWindow(String s, String t) {
        int m=s.length(),n=t.length();

        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> f=new HashMap<>();

        for(char c:t.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        int l=0,r=0,min=Integer.MAX_VALUE;
        int st=0,c=0;

        while(r<m){
            char ch=s.charAt(r);
            if(mp.containsKey(ch)){

                f.put(ch,f.getOrDefault(ch,0)+1);

                if(mp.get(ch).equals(f.get(ch))){
                    c++;
                }
            }

            while(c==mp.size()){
                if(r-l+1 < min){
                    min=Math.min(min,r-l+1);
                    st=l;
                }

                char x=s.charAt(l);
                
                    if(mp.containsKey(x)){

                        f.put(x,f.getOrDefault(x,0)-1);

                        if(f.get(x) < mp.get(x)){
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

        return min==Integer.MAX_VALUE?"":s.substring(st,st+min);

    }
}