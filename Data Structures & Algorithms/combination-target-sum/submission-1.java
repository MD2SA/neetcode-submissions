class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, 0, target, cur, res);
        return res;
    }

    private void backtrack(int[] nums, int i, int target, List<Integer> cur, List<List<Integer>> res) {
        if(i>=nums.length || target < 0) {
            return;
        }
        if(target==0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, i, target-nums[i], cur, res);

        cur.remove(cur.size()-1);
        backtrack(nums, i+1, target, cur, res);
    }
}
