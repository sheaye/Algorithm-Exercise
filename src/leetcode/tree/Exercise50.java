package leetcode.tree;

import common.TreeNode;

import java.util.ArrayList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n ) space is pretty straight forward. Could you devise a constant space solution?
 */
public class Exercise50 {

    public static void main(String[] args) {
        Exercise50 exe = new Exercise50();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < 64; i++) {
            builder.append(i).append(",");
        }
        TreeNode tree = TreeNode.createTreeNode(builder.toString());
//        TreeNode tree = TreeNode.createTreeNode("6,2,5,1,4,#,9,#,#,3,7,8,#");

        exe.morrisTraverse(tree);
//        TreeNode tree = TreeNode.createTreeNode("1,#,3,#,2");
//        TreeNode tree = TreeNode.createTreeNode("3,#,1,2");
//        System.out.println(tree.toString());
//        exe.recoverTree2(tree);
//        System.out.println(tree.toString());
    }


    public void recoverTree3(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTree3(root.left, Integer.MIN_VALUE, root.val);
        recoverTree3(root.right, root.val, Integer.MAX_VALUE);
        if (list.size() < 2) {
            return;
        }
        TreeNode node1 = list.get(0);
        TreeNode node2 = list.get(1);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void recoverTree3(TreeNode node, int min, int max) {
        if (node == null || list.size() > 1) {
            return;
        }
        if (node.val < min || node.val > max) {
            list.add(node);
        }
        recoverTree3(node.left, min, node.val);
        recoverTree3(node.right, node.val, max);
    }


    ArrayList<TreeNode> list = new ArrayList<>();

    public void recoverTree2(TreeNode root) {
        inOrder(root);
        postOrder(root);
        if (list.size() < 2) {
            return;
        }
        TreeNode pre = list.get(0);
        TreeNode post = list.get(1);
        int temp = pre.val;
        pre.val = post.val;
        post.val = temp;
    }


    TreeNode preNode;

    public void inOrder(TreeNode root) {
        if (root == null || list.size() > 0) {
            return;
        }
        inOrder(root.left);
        if (preNode != null && preNode.val > root.val && list.size() < 1) {
            list.add(preNode);
            return;
        }
        preNode = root;
        inOrder(root.right);
    }

    TreeNode postNode;

    public void postOrder(TreeNode root) {
        if (root == null || list.size() > 1) {
            return;
        }
        postOrder(root.right);
        if (postNode != null && postNode.val < root.val && list.size() < 2) {
            list.add(postNode);
            return;
        }
        postNode = root;
        postOrder(root.left);
    }

    /**
     * @param root
     */
    public void morrisTraverse(TreeNode root) {
        TreeNode pre;
        while (root != null) {
            if (root.left == null) {
                System.out.println("找到当前子树最左节点：root = " + root.val);
                root = root.right;
                continue;
            }
            pre = root.left;
            while (pre.right != null && pre.right != root) {
                pre = pre.right;
            }
            if (pre.right == null) {
                System.out.println("找到当前子树最右节点,加线索：root = " + root.val);
                pre.right = root;
                root = root.left;
            } else {// pre.right==root
                pre.right = null;
                System.out.println("去线索：root = " + root.val);
                root = root.right;
            }
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        while (root != null) {
            if (root.left == null) {
                detect(nodes, pre, root);
                pre = root;
                root = root.right;
            } else {


            }

        }
    }

    private void detect(ArrayList<TreeNode> nodes, TreeNode pre, TreeNode cur) {
        if (pre != null && pre.val > cur.val) {
            nodes.add(pre);
        }
    }

}
