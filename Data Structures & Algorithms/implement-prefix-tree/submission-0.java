class PrefixTree {

    private class TreeNode {
        PrefixTree tree = new PrefixTree();
        boolean isWord;
    }

    private final Map<Character, TreeNode> map;

    public PrefixTree() {
          this.map = new HashMap<>();
    }

    public void insert(String word) {
        TreeNode curNode = null;
        PrefixTree curTree = this;
        for(char c : word.toCharArray()) {
            curTree.map.putIfAbsent(c, new TreeNode());
            curNode = curTree.map.get(c);
            curTree = curNode.tree;
        }
        curNode.isWord = true;
    }

    public boolean search(String word) {
        boolean isWord = false;
        PrefixTree curTree = this;
        for(char c : word.toCharArray()) {
            var curNode = curTree.map.get(c);
            if(curNode == null) return false;
            isWord = curNode.isWord;
            curTree = curNode.tree;
        }
        return isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curTree = this;
        for(char c : prefix.toCharArray()) {
            var curNode = curTree.map.get(c);
            if(curNode == null) return false;
            curTree = curNode.tree;
        }
        return true;
    }
}
