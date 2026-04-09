/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        insert(root, 0, map);
        return new ArrayList<>(map.values());
    }

    private void insert(TreeNode node, int level, Map<Integer, Integer> map) {
        if(node == null) return;
        map.put(level, Math.max(node.val,map.getOrDefault(level,-100)));
        insert(node.left, level+1, map);
        insert(node.right, level+1, map);
    }
}
