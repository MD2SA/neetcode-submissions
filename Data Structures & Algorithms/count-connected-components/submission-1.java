class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++) 
            adjList.add(new ArrayList<>());

        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int res = 0;
        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i<n; i++) {
            if(!seen.contains(i)) {
                dfs(i, seen, adjList);
                res++;
            }
        }
        return res;
    }

    private void dfs(int cur, Set<Integer> seen, List<List<Integer>> adjList) {
        seen.add(cur);
        for(int node : adjList.get(cur)) {
            if(!seen.contains(node))
                dfs(node, seen, adjList);
        }
    }

}
