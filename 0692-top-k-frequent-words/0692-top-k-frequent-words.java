class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> sc=new ArrayList<>();
        HashMap<String,Integer> mp=new HashMap<>();

        for(String s:words){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }

        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->
        {
            if(!mp.get(a).equals(mp.get(b))){
                return mp.get(a)-mp.get(b);
            }
            else{
                return b.compareTo(a);
            }
        });
        
        for(String x:mp.keySet()){
            pq.add(x);
            if(pq.size()>k){
                pq.poll();
            }
        }

        for(int i=0;i<k;i++){
            sc.add(pq.poll());
        }
        Collections.reverse(sc);
        return sc;

       
    }
}