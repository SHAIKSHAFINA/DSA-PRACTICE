class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->a[1]-b[1]);
        int a[][]=new int[queries.length][2];
        
        for(int i=0;i<queries.length;i++){
            a[i][0]=queries[i];
            a[i][1]=i;
        }

        Arrays.sort(a,(c,d)->c[0]-d[0]);
        
        int l=0,r=0;
        HashMap<Integer,Integer> mp=new HashMap<>();

        int [] arr=new int[queries.length];
        int c=0;
        int i=0;
        
        while(i<a.length){
            while(r<logs.length && logs[r][1]<= a[i][0]){
                    mp.put(logs[r][0],mp.getOrDefault(logs[r][0],0)+1);
                    if(mp.get(logs[r][0])==1){
                        c++;
                    }
                    r++;
            
            }
            while(l<r && logs[l][1]<a[i][0]-x){
                    mp.put(logs[l][0],mp.getOrDefault(logs[l][0],0)-1);

                    if(mp.get(logs[l][0]) ==0){
                        c--;
                        mp.remove(logs[l][0]);
                    }
                    l++;
            }
            
            arr[a[i][1]]=n-c;
            i++;

        }

        return arr;

    }
}