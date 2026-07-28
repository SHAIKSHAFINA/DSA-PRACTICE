class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;

        HashMap<String,List<String>> mp=new HashMap<>();

        for(String s:strs){
            int freq[]=new int[26];
            for(int i=0;i<s.length();i++){
                freq[s.charAt(i)-'a']++;
            }

            StringBuilder key=new StringBuilder();
            for(int i=0;i<26;i++){
                key.append(freq[i]).append("#");
            }
            String k=key.toString();
            List<String> sc;
            if(!mp.containsKey(k)){
                sc=new ArrayList<>();
            }
            else{
                sc=mp.get(k);
            }
            sc.add(s);
            mp.put(k,sc);
        }


        return new ArrayList<>(mp.values());

    }
}