class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]> sc=new ArrayList<>();

        for(int i=0;i<n;i++){
                sc.add(intervals[i]);
        }
        sc.add(newInterval);

        Collections.sort(sc , (a,b)->a[0]-b[0]);

        int lastEnd=sc.get(0)[1];
        int lastStart=sc.get(0)[0];

        ArrayList<int[]> x=new ArrayList<>();

        for(int i=1;i<sc.size();i++){
            if(sc.get(i)[0] <=lastEnd){
                lastEnd=Math.max(lastEnd,sc.get(i)[1]);
            }
            else{
                x.add(new int[]{lastStart,lastEnd});
                lastStart=sc.get(i)[0];
                lastEnd=sc.get(i)[1];
            }
        }
        x.add(new int[]{lastStart,lastEnd});
        return x.toArray(new int[x.size()][]);
    }
}