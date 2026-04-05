class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // encoded string -> list of strings
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] letters = new int[26];
            for(char c : str.toCharArray())
                letters[c-'a']++;
            String encodedStr = Arrays.toString(letters);

            map.putIfAbsent(encodedStr, new ArrayList<>());
            map.get(encodedStr).add(str);
        }
        return List.copyOf(map.values());
    }
}
