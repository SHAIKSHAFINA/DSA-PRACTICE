class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        ArrayList<Integer> sc=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sc.add(grid[i][j]);
            }
        }

        Collections.sort(sc);
        int median=sc.get(sc.size()/2);
        int c=0;

        for(int i=0;i<sc.size();i++){
            int diff=Math.abs(median-sc.get(i));
            if(diff % x!=0){
                return -1;
            }
            c+=(diff)/x;
        }

        return c;

    }
}