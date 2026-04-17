/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node copy = new Node(node.val);
        map.put(copy.val, copy);
        List<Node> neighbors = new ArrayList<>();
        for(Node n : node.neighbors) {
            if(map.containsKey(n.val)) neighbors.add(map.get(n.val));
            else neighbors.add(cloneGraph(n));
        }
        copy.neighbors = neighbors;
        return copy;
    }

}