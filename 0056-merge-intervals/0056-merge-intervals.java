class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> sc=new ArrayList<>();
        if(n==1 || n==0){
            return intervals;
        }
        //sc.add(intervals[0][0]);
        int currStart=intervals[0][0];
        int currEnd=intervals[0][1];

        for(int i=1;i<n;i++){
            int[] a=new int[2];
            if(intervals[i][0] <= currEnd){
                currEnd=Math.max(currEnd,intervals[i][1]);
            }
            else{
                sc.add(new int[]{currStart,currEnd});
               currStart=intervals[i][0];
               currEnd=intervals[i][1];
            }
        }
        sc.add(new int[]{currStart,currEnd});

        int[][] arr=new int[sc.size()][2];

        for(int i=0;i<sc.size();i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.get(i)[j];
            }
        }

        return arr;
    }
}