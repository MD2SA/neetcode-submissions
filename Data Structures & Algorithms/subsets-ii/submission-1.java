class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for(int j = i; j<nums.length; j++) {
            if(j>i && nums[j] == nums[j-1]) continue;
            cur.add(nums[j]);
            backtrack(nums, j+1, cur);
            cur.remove(cur.size()-1);
        }
    }
}
