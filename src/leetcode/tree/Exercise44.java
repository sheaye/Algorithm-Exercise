package leetcode.tree;

import common.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Exercise44 {

    public static void main(String[] args) {
        Exercise44 exe = new Exercise44();
        System.out.println(exe.buildTree(new int[]{1, 2, 4, 6, 7, 5, 8, 3, 9, 10}, new int[]{6, 4, 7, 2, 8, 5, 1, 9, 3, 10}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length < 1 || inorder.length < 1 || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int val = preOrder[preLeft];
        TreeNode root = new TreeNode(val);
        int rootIndex = 0;
        for (int i = inLeft; i < inRight + 1; i++) {
            if (inOrder[i] == val) {
                rootIndex = i;
                break;
            }
        }
        int rootLeftPreRight = preLeft + rootIndex - inLeft;
        root.left = buildTree(preOrder, preLeft + 1, rootLeftPreRight, inOrder, inLeft, rootIndex - 1);
        root.right = buildTree(preOrder, rootLeftPreRight + 1, preRight, inOrder, rootIndex + 1, inRight);
        return root;
    }

}
