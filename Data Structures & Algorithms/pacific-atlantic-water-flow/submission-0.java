class Solution {

    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] atlantic = new boolean[rows][cols];
        boolean[][] pacific = new boolean[rows][cols];

        for(int i = 0; i<rows; i++) {
            dfs(0,i, heights[i][0], pacific);
            dfs(cols-1,i, heights[i][cols-1], atlantic);
        }
        for(int i = 0; i<cols; i++) {
            dfs(i,0, heights[0][i], pacific);
            dfs(i,rows-1, heights[rows-1][i], atlantic);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<rows; i++) {
            for(int j = 0; j<cols; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i,j));
            }
        }

        return res;
    }

    private void dfs(int col, int row, int prev, boolean[][] visited) {
        if(
            col<0 || row<0 ||
            row>=heights.length || col>=heights[row].length ||
            visited[row][col] || heights[row][col] < prev
        ) {
            return;
        }
        visited[row][col] = true;
        int val = heights[row][col];
        dfs(col, row+1, val, visited);
        dfs(col, row-1, val, visited);
        dfs(col+1, row, val, visited);
        dfs(col-1, row, val, visited);
    }
}
