class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        ArrayList<int[]> sc=new ArrayList<>();
        int i=0;

        while(i<n && intervals[i][1] < newInterval[0]){
            sc.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;

        }
        sc.add(newInterval);

        while(i<n){
            sc.add(intervals[i]);
            i++;
        }

        return sc.toArray(new int[sc.size()][]);
    }
}