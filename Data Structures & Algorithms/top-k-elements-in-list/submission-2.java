class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n,0)+1);

        List<Data> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            Data data = new Data(entry.getKey(), entry.getValue());
            list.add(data);
        }
        list.sort((a,b)-> b.times-a.times);

        int[] res = new int[k];
        for(int i = 0; i<k; i++) 
            res[i] = list.get(i).n;

        return res;
    }

    private class Data {
        int n;
        int times;
        public Data(int n, int times) {
            this.n = n; this.times = times;
        }
    }
}
