class Solution {
    public boolean[][] visited;
    public int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        int res = 0;

        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++) {
                if(!visited[i][j] && grid[i][j] != 0) {
                    int cur = bfs(j,i);
                    res = Math.max(cur, res);
                }
            }
        }
        return res;
    }

    private int bfs(int j, int i) {
        int sum = 0;
        int[][] offsets = { {0,1}, {0,-1}, {1,0}, {-1,0} };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{j,i});
        visited[i][j] = true;
        
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            sum +=grid[y][x];
            for(int[] offset : offsets) {
                int x0 = x+offset[0];
                int y0 = y+offset[1];
                if(
                    y0>=0 && y0<visited.length &&
                    x0>=0 && x0<visited[y0].length &&
                    !visited[y0][x0] && grid[y0][x0] != 0
                ) {
                    queue.offer(new int[]{x0,y0});
                    visited[y0][x0] = true;
                }
            }
        }
        return sum;
    }
    

}
