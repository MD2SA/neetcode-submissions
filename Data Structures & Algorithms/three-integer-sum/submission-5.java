class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int left = 0; left<nums.length; left++) {
            if(nums[left]>0) break;
            if(left>0 && nums[left] == nums[left-1]) continue;

            int mid = left+1, right = nums.length-1;
            while(mid<right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if(sum > 0) {
                    right--;
                } else if(sum < 0) {
                    mid++;
                } else {
                    list.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    mid++;
                    right--;
                    while(mid<right && nums[mid] == nums[mid-1]) mid++;
                }   
            }
        }
        return list;
    }
}