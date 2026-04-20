class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(target, 0, nums, new ArrayList<>());
        return res;
    }

    private void backtrack(int target, int i, int[] nums, List<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(i>=nums.length || target < 0) 
            return;

        cur.add(nums[i]);
        backtrack(target-nums[i], i, nums, cur);

        cur.remove(cur.size()-1);
        backtrack(target, i+1, nums, cur);
    }
}
