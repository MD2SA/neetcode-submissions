class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails) {
            set.add(getClean(email));
        }
        return set.size();
    }

    private String getClean(String s) {
        StringBuilder sb = new StringBuilder();
        boolean local = true;
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(local) {
                if(c == '.') continue;
                else if(c == '+') {
                    while(s.charAt(i+1) != '@') i++;
                    continue;
                } else if(c == '@') local = false;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}