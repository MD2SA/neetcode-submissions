class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sorted string -> list of strings
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++) {
            String str = strs[i];
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortedStr = new String(array);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }
        return List.copyOf(map.values());
    }
}
