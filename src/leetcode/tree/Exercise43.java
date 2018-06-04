package leetcode.tree;

import common.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class Exercise43 {

    public static void main(String[] args) {
        Exercise43 exe = new Exercise43();
        System.out.println(exe.buildTree(new int[]{4, 2, 1, 7, 5, 8, 3, 6}, new int[]{4, 2, 7, 8, 5, 6, 3, 1}).toString());
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if ((inorder == null) || (postorder == null) || (inorder.length == 0) || (postorder.length == 0)) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int val = postOrder[postEnd];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == val) {
                index = i;
            }
        }
        root.left = buildTree(inOrder, inStart, index - 1, postOrder, postStart, postStart + index - inStart - 1);
        root.right = buildTree(inOrder, index + 1, inEnd, postOrder, postStart + index - inStart, postEnd - 1);
        return root;
    }

    /*public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int iStart, int[] postorder, int pLeft, int pRight) {
        if (pLeft > pRight) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[pRight]);
        for (int i = iStart; i < inorder.length; i++) {
            for (int j = pLeft; j < pRight; j++) {
                if (inorder[i] == postorder[j]) {
                    if (j != pRight - 1) {
                        node.left = buildTree(inorder, i + 1, postorder, pLeft, j);
                        pLeft = j + 1;
                        break;
                    } else {
                        node.right = buildTree(inorder, i + 1, postorder, pLeft, j);
                        return node;
                    }
                }
            }
        }
        return node;
    }
*/
}
