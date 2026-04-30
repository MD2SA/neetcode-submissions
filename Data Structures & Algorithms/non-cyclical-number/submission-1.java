class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.addAll(Arrays.asList(n,2,4,16,37,58,89,145,42,20,4));
        while(n != 1) {
            n = getNew(n);
            if(seen.contains(n)) return false;
            seen.add(n);
        }
        return true;
    }

    private int getNew(int n) {
        int res = 0;
        while(n!=0) {
            res+=Math.pow((n%10),2);
            n/=10;
        }
        return res;
    }
}
