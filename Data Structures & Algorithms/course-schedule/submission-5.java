class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] combo : prerequisites) {
            map.putIfAbsent(combo[0], new HashSet<>());
            map.get(combo[0]).add(combo[1]);
        }
        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if(!dfs(entry.getKey(), new HashSet<>(), map))
                return false;
        }

        return true;
    }

    private boolean dfs(int key, Set<Integer> seen, Map<Integer,Set<Integer>> map) {
        if(!map.containsKey(key)) return true;
        if(seen.contains(key)) return false;
        seen.add(key);
        for(int n : map.get(key)) {
            if(!dfs(n, seen, map)) return false;
        }
        seen.remove(key);
        map.put(key, new HashSet<>());
        return true;
    }

}
