class PrefixTree {

    private class TreeNode {
        Map<Character, TreeNode> map = new HashMap<>();
        boolean isWord;
    }

    private final TreeNode node;

    public PrefixTree() {
          this.node = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curNode = this.node;
        for(char c : word.toCharArray()) {
            curNode.map.putIfAbsent(c, new TreeNode());
            curNode = curNode.map.get(c);
        }
        curNode.isWord = true;
    }

    public boolean search(String word) {
        TreeNode curNode = this.node;
        for(char c : word.toCharArray()) {
            curNode = curNode.map.get(c);
            if(curNode == null) return false;
        }
        return curNode.isWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curNode = this.node;
        for(char c : prefix.toCharArray()) {
            curNode = curNode.map.get(c);
            if(curNode == null) return false;
        }
        return true;
    }
}
