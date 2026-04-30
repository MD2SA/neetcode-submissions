class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.add(n);
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
