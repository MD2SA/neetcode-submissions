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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        insert(root, 0, list);
        return list;
    }

    private void insert(TreeNode node, int level, List<List<Integer>> list) {
        if(node == null) return;
        if(list.size()<=level) list.add(new ArrayList<>());
        list.get(level).add(node.val);
        insert(node.left, level+1, list);
        insert(node.right, level+1, list);
    }
}
