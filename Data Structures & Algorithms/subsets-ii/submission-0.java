class Solution {
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, cur);
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> cur) {
        if(nums.length<=i){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, i+1, cur);

        cur.remove(cur.size()-1);
        while(i<nums.length-1 && nums[i]==nums[i+1])i++;
        backtrack(nums, i+1, cur);
    }
}
