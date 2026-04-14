class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int n : nums) list.add(n);
        return backtrack(list);
    }

    private List<List<Integer>> backtrack(List<Integer> list) {
        if(list.size() == 1) return new ArrayList<>(Arrays.asList(list));
        int elem = list.remove(0);
        List<List<Integer>> subsets = backtrack(list);
        int size = subsets.get(0).size();
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> subset : subsets) {
            for(int i = 0; i<size+1; i++) {
                List<Integer> copy = new LinkedList<>(subset);
                copy.add(i, elem);
                res.add(copy);
            }
        }
        return res;
    }
}
