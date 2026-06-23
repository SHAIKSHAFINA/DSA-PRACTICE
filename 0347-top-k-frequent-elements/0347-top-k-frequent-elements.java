class Solution {
    class Pair{
        int num;
        int f;

        Pair(int x,int y){
            num=x;
            f=y;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int [] a=new int[k];
        //ArrayList<Integer> sc=new ArrayList<>();
        int n=nums.length;
        //Arrays.sort(nums);
        HashMap<Integer,Integer> mp=new HashMap<>();

        for(int x:nums){
            mp.put(x,mp.getOrDefault(x,0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((g,b)->g.f-b.f);
       
       for(Map.Entry<Integer,Integer> entry:mp.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));

            if(pq.size()>k){
                pq.poll();
            }
       }

        int i=0;
       while(!pq.isEmpty()){
            Pair pp=pq.poll();
            a[i]=pp.num;
            i++;
       }

       return a;
       
    }
}