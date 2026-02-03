class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer>sc=new ArrayList<>();
        Deque<Integer>dq=new LinkedList<>();
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i>=k-1){
                sc.add(nums[dq.peekFirst()]);
            }
        }
        return sc.stream().mapToInt(Integer::intValue).toArray();

    }
}