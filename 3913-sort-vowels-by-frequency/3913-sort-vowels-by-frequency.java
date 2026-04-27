class Solution {
    public String sortVowels(String s) {
        int n=s.length();

        int freq[]=new int[26];
        int first[]=new int[26];
        Arrays.fill(first,-1);
        Set<Character> vowels = Set.of('a','e','i','o','u');

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(vowels.contains(ch)){
                if(freq[ch-'a']==0){
                    first[ch-'a']=i;
                }
                freq[ch-'a']++;
            }
        }

        List<Character> v = Arrays.asList('a','e','i','o','u');
        Collections.sort(v,(a,b)-> 
                         {
                             if(freq[a-'a']!=freq[b-'a']){
                                 return freq[b-'a']-freq[a-'a'];
                             }
                             else{
                                 return first[a-'a']-first[b-'a'];
                             }
                         });

        StringBuilder sorted=new StringBuilder();

        for(char ch:v){
            int count= freq[ch-'a'];
            while(count-->0){
                sorted.append(ch);
            }
        }

        StringBuilder res=new StringBuilder();
        int j=0;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(v.contains(ch)){
                res.append(sorted.charAt(j++));
            }
            else{
                res.append(ch);
            }
        }

        return res.toString();
    }
}