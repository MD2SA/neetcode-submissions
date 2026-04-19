class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] combo : prerequisites) {
            map.putIfAbsent(combo[0], new HashSet<>());
            map.get(combo[0]).add(combo[1]);
        }

        for(int i = 0; i<numCourses; i++) {
            if(!dfs(i, new HashSet<>(), map)) 
                return false;
        }
        return true;
    }

    private boolean dfs(int cur, Set<Integer> seen, Map<Integer, Set<Integer>> map) {
        if(!map.containsKey(cur)) return true;
        if(seen.contains(cur)) return false;

        seen.add(cur);
        for(int n : map.get(cur)) {
            if(!dfs(n, seen, map))
                return false;
        }
        seen.remove(cur);
        map.put(cur, new HashSet<>());

        return true;
    }
}
