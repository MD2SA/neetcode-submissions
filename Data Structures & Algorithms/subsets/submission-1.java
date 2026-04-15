class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        for(int n : nums) subset.add(n);
        return backtrack(subset);
    }

    private List<List<Integer>> backtrack(List<Integer> subset) {
        if(subset.size()==0) {   
            return new ArrayList<>(Arrays.asList(subset));
        }
        int elem = subset.remove(0);
        List<List<Integer>> res = backtrack(subset);
        List<List<Integer>> newRes = new ArrayList<>();
        for(List<Integer> sub : res) {
            newRes.add(sub);
            List<Integer> copy = new ArrayList<>(sub);
            copy.add(elem);
            newRes.add(copy);
        }

        return newRes;
    }
}
