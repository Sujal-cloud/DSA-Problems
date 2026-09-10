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
    int count = 0;

    private int[] postorder(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int[] left = postorder(root.left);
        int[] right = postorder(root.right);

        int subTreeSum = left[0]+right[0]+root.val;
        int subTreeCnt = left[1]+right[1]+1;

        if(subTreeSum / subTreeCnt == root.val) {
            count++;
        }

        return new int[]{subTreeSum, subTreeCnt};
    }
    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return count;
    }
}