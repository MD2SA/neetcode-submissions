class Solution {
    
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, cur);
        return res;
    }

    private void backtrack(int[] nums, int target, int i, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0 || nums.length <= i) return;

        // include nums[i]
        cur.add(nums[i]);
        backtrack(nums, target-nums[i], i+1, cur);
        cur.remove(cur.size()-1);
        // skip nums[i]
        while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        backtrack(nums, target, i+1, cur);
    }
}
