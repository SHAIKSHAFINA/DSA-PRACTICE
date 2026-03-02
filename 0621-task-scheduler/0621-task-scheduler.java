class Solution {
    public int leastInterval(char[] tasks, int n) {
        int x=tasks.length;
        HashMap<Character,Integer> mp=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<x;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }

        for(int num:mp.values()){
            pq.add(num);
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

            for(int y:sc){
                if(y>0){
                    pq.add(y);
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