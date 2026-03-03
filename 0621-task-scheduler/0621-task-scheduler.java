class Solution {
    public int leastInterval(char[] tasks, int n) {
        int x=tasks.length;

        if(n==0) return tasks.length;
        int[] freq=new int[26];
        
        for(char c:tasks){
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        int max=freq[25];
        int g=max-1;

        int f=g*n;

        for(int i=24;i>=0;i--){
            f-=Math.min(freq[i],g);
        }
        
        if(f>0){
            return tasks.length+f;
        }
        else{
            return tasks.length;
        }





    }
}