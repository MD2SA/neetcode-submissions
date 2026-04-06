class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0; 
        Set<String> set = new HashSet<>();
        while(left<nums.length-2) {
            int mid = left+1;
            int right = nums.length-1;
            int lVal = nums[left];
            while(mid<right) {
                int mVal = nums[mid];
                int rVal = nums[right];
                int sum = lVal + mVal + rVal;
                if(sum == 0) {
                    String encoded = ""+lVal+mVal+rVal;
                    if(set.add(encoded))
                        list.add(new ArrayList<>(Arrays.asList(lVal,mVal,rVal)));
                }
                if(sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
            left++;
        }
        return list;
    }
}
