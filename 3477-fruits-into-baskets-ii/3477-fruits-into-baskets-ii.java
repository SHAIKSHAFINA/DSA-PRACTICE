class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        //Arrays.sort(fruits);
        int c=0;
        int n=fruits.length;
        boolean freq[]=new boolean[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(fruits[i]<=baskets[j] && freq[j]==false){
                    freq[j]=true;
                    break;
                }
            }
        }

        for(boolean x:freq){
            if(x==false){
                c++;
            }
        }

        return c;
    }
}