class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[i].length; j++) {
                if(visited[i][j]) continue;
                if(grid[i][j] == '1') 
                    res++;
                bfs(grid, visited, j, i);
            }
        }
        return res;
    }

    public void bfs(char[][] grid, boolean[][] visited, int j, int i) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{j,i});
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            if(visited[y][x]) continue;

            visited[y][x] = true;
            if(grid[y][x] == '0') continue;

            if(y+1<grid.length)
                queue.offer(new int[]{x,y+1});
            if(y>0)
                queue.offer(new int[]{x,y-1});
            if(x+1<grid[0].length)
                queue.offer(new int[]{x+1,y});
            if(x>0)
                queue.offer(new int[]{x-1,y});
        }
    }
}
