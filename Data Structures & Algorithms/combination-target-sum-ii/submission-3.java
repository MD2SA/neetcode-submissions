class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, cur, res);
        return res;
    }

    private void backtrack(int[] nums, int i, int target, List<Integer> cur, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(nums.length<=i || target <0) {
            return;
        }


        cur.add(nums[i]);
        backtrack(nums, i+1, target-nums[i], cur, res);
        
        cur.remove(cur.size()-1);
        while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
        backtrack(nums, i+1, target, cur, res);
    }
}
