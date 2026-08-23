class Solution {
    List<List<String>> ans=new ArrayList<>();
    Map<String,List<String>> mp=new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
       Set<String> sc=new HashSet<>(wordList);
       HashMap<String,Integer> steps=new HashMap<>();
       Queue<String> q=new LinkedList<>();

       if(!sc.contains(endWord)) return ans;

       q.add(beginWord);
       steps.put(beginWord,1);
       int level=0;

       while(!q.isEmpty()){
    
            int size=q.size();
            level++;

            for(int i=0;i<size;i++){
                String s=q.poll();
                char arr[]=s.toCharArray();

                for(int j=0;j<s.length();j++){
                    char org=arr[j];

                    for(char ch='a';ch<='z';ch++){
                        if(org==ch) continue;
                        arr[j]=ch;
                        String newString=new String(arr);
                        if(!sc.contains(newString)){
                            continue;
                        }

                        if(!steps.containsKey(newString)){
                            steps.put(newString,level+1);
                            q.add(newString);

                            mp.put(newString,new ArrayList<>());
                            mp.get(newString).add(s);
                        }
                        else if(steps.get(newString)==level+1){
                            mp.get(newString).add(s);
                        }

                    }

                    arr[j]=org;
                }
        }

        if(steps.containsKey(endWord)){
                break;
        }
        }

        if(!steps.containsKey(endWord)){
                return ans;
        }

       List<String> path=new ArrayList<>();
       path.add(endWord);

       dfs(endWord,beginWord,path);

       return ans;

    }

    void dfs(String word,String beginWord,List<String> path){
        if(word.equals(beginWord)){
            List<String> temp=new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        for(String p:mp.get(word)){
            path.add(p);
            dfs(p,beginWord,path);
            path.remove(path.size()-1);
        }
    }
}