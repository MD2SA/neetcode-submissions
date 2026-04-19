class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges)  {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        if(!dfs(0,-1, seen, adjList)) return false;
        return seen.size() == n;
    }

    private boolean dfs(int node, int prev, Set<Integer> seen, List<List<Integer>> adjList)  {
        seen.add(node);
        for(int nodeI : adjList.get(node)){
            if(nodeI == prev)
                continue;
            if(seen.contains(nodeI))
                return false;
            if(!dfs(nodeI, node, seen, adjList)) 
                return false;
        }
        return true;
    }
}
