class Solution {

    private List<Integer> subset = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        if(start>=nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[start]);
        dfs(nums, start+1);

        subset.remove(subset.size() - 1);
        dfs(nums,start+1);
    }
}
