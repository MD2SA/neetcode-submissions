class Solution {
    
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        for(int i : nums) cur.add(i);
        backtrack(cur);
        return res;
    }

    private void backtrack(List<Integer> cur){
        if(cur.size()==1){
            res.add(new ArrayList(cur));
            return;
        }
        int elem = cur.remove(0);
        backtrack(cur);
        List<List<Integer>> toAdd = new ArrayList<>();
        for(List<Integer> list : res){
            for(int i = 0; i<list.size()+1; i++) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(i,elem);
                toAdd.add(copy);
            }
        }
        res = toAdd;
    }
}
