class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> sc=new HashSet<>();

        for(int i=0;i<n;i++){
            sc.add(nums[i]);
        }
        int max=0;
        for(int x:sc){
            
            if(!sc.contains(x-1)){
               
                int curr=x;
                int c=1;
                
                while(sc.contains(curr+1)){
                    curr++;
                    c++;
                }
                 max=Math.max(max,c);
            }
                 
            
        }
        return max;
    }
}