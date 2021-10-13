package binarytree;


// 二叉树求和路径， 在一个二叉树中，求判定是否存在一条从根节点到叶节点的路径，
// 这条路径上所有节点的值加起来的和等于给定的值。

/**
 * 思路：
 * 1、回溯法，深度遍历
 * 遍历所有的路径，如果出现相等，则返回
 */
public class SumPath {

    private boolean ans = false;

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }

    public void traveral(TreeNode node, int num, int sum) {
        // 剪枝
        if(ans) {
            return;
        }
        if (num == sum && node.left == null && node.right == null) {
            ans = true;
        }
        if (node.right != null) {
            traveral(node.right, num + node.right.data, sum);
        }
        if (node.left != null) {
            traveral(node.left, num + node.left.data, sum);
        }
    }

    public boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        traveral(node, node.data, sum);
        return ans;
    }
}
