class PrefixTree {

    private class TreeNode {
        TreeNode[] map = new TreeNode[26];
        boolean isWord;
    }

    private final TreeNode node;

    public PrefixTree() {
          this.node = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curNode = this.node;
        for(char c : word.toCharArray()) {
            if(curNode.map[c-'a'] == null) {
                curNode.map[c-'a'] = new TreeNode();
            }
            curNode = curNode.map[c-'a'];
        }
        curNode.isWord = true;
    }

    public boolean search(String word) {
        TreeNode curNode = this.node;
        for(char c : word.toCharArray()) {
            curNode = curNode.map[c-'a'];
            if(curNode == null) return false;
        }
        return curNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curNode = this.node;
        for(char c : prefix.toCharArray()) {
            curNode = curNode.map[c-'a'];
            if(curNode == null) return false;
        }
        return true;
    }
}
