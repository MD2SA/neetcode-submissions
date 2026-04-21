class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<=i; j++) {
                if(j == 0 || j == i)
                    row.add(1);
                else {
                    List<Integer> aboveRow = res.get(i-1);
                    row.add(aboveRow.get(j-1)+aboveRow.get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}