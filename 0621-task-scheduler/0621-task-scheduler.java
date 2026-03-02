class Solution {
    public int leastInterval(char[] tasks, int n) {
        int x=tasks.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character,Integer> mp=new HashMap<>();

        for(int i=0;i<x;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }

        for(int num:mp.values()){
            pq.offer(num);
        }

        int time=0;

        while(!pq.isEmpty()){
            ArrayList<Integer> sc=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!pq.isEmpty()){
                    int freq=pq.poll();
                    freq--;
                    sc.add(freq);
                }
            }

        
        for(int f:sc){
            if(f>0){
                pq.add(f);
            }
        }

            if(pq.isEmpty()){
                time+=sc.size();
            }
            else{
                time+=n+1;
            }
        
        }
        
        return time;

        
    }
}