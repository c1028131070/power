package binarytree;

import java.util.Arrays;
import java.util.LinkedList;

// 二叉树求和路径， 在一个二叉树中，求判定是否存在一条从根节点到叶节点的路径，
// 这条路径上所有节点的值加起来的和等于给定的值。
public class SumPathByGuiMeng {

    private static boolean m = false;

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraveral(int num, TreeNode node, int sum) {
        if (num == sum && node.leftChild == null && node.rightChild == null) {
            m = true;
        }
        if (node.rightChild != null) {
            preOrderTraveral(num + node.rightChild.data, node.rightChild, sum);
        }
        if (node.leftChild != null) {
            preOrderTraveral(num + node.leftChild.data, node.leftChild, sum);
        }
    }

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        preOrderTraveral(node.data, node, sum);
        return m;
    }

    public static void main(String[] args) {
        //初始化测试数据
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(4, 2, null, null, 3, 5));
        Integer sum = 6;
        //创建二叉树
        TreeNode node = createBinaryTree(inputList);
        //比较判断
        boolean b = hasPathSum(node, sum);
        if (b) {
            System.out.println("存在相等");
        } else {
            System.out.println("不存在相等");
        }
    }
}
