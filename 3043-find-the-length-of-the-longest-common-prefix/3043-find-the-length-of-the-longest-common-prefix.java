class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n=arr1.length;

        HashSet<Integer> s=new HashSet<>();
        
        for(int num:arr1){
            while(num >0){
                s.add(num);
                num/=10;
            }
        }

        int res=0;
        for(int num:arr2){
            while(!s.contains(num) && num >0){
                num/=10;
            }

            if(num>0){
                res=Math.max(res, (int)Math.log10(num)+1);
            }
        }

        return res;
        
    }
}