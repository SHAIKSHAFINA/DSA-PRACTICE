class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); 
        
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        
        return res;
    }

    void backtrack(int start, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        
        res.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            backtrack(i + 1, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}