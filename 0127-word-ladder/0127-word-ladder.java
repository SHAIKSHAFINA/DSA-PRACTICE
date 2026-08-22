class Solution {

    class Pair{
        String s;
        int n;

        Pair(String x,int m){
            s=x;
            n=m;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> mp=new HashSet<>(wordList);
        Queue<Pair> q=new LinkedList<>();

        if(!mp.contains(endWord)) return 0;

        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p=q.poll();
            String c=p.s;
            int d=p.n;

            char arr[]=c.toCharArray();

            for(int i=0;i<c.length();i++){
                char org=arr[i];

                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String newString=new String(arr);
                    if(newString.equals(endWord)) return d+1;

                    if(mp.contains(newString)){
                        mp.remove(newString);
                        q.add(new Pair(newString,d+1));
                    }
                }

                arr[i]=org;
            }

        }

       return 0;
    }
    
}