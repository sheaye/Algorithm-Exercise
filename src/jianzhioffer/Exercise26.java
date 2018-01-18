package jianzhioffer;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Exercise26 {

    public static void main(String[] args) {
        Exercise26 exe = new Exercise26();
        TreeNode linkedList = exe.Convert(TreeNode.createTreeNode());
        TreeNode last = linkedList;
        while (linkedList != null) {
            System.out.println(linkedList.val);
            last = linkedList.left;
            linkedList = linkedList.right;
        }

        System.out.println();

        while (last != null) {
            System.out.println(last.val);
            last = last.left;
        }
    }

    public TreeNode Convert2(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
//      创建一个辅助栈用于按顺序存储节点
        Stack<TreeNode> nodeStack = new Stack<>();
//      遍历TreeNode,倒序推进栈中，这样从栈顶到栈顶的元素是从小到大的顺序。
        push(nodeStack, pRootOfTree);

//      保存栈顶元素的引用，即双链表的头结点引用，也就是双链表的引用
        TreeNode linkedList = nodeStack.pop();
//      获取当前节点
        TreeNode current = linkedList;
//      当前节点的左节点
        TreeNode left = null;
//      遍历栈，将栈中元素从左至右，将TreeNode重新排列
        while (!nodeStack.empty()) {
//          取出栈顶元素，作为当前节点的右节点
            current.right = nodeStack.pop();
//          暂存当前节点
            left = current;
//          遍历将下一个节点作为当前节点
            current = current.right;
//          并将当前节点的上一节点，作为做节点
            current.left = left;
        }
        return linkedList;

    }

    private void push(Stack<TreeNode> stack, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        push(stack, treeNode.right);
        stack.push(treeNode);
        push(stack, treeNode.left);
    }

//  不使用辅助栈的方法
//  递归重排左子树和右子树，并将重排后的左子树、右子树按规则与根节点重新拼接，始终返回重排后的最左节点
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode leftNode = pRootOfTree.left;
        TreeNode rightNode = pRootOfTree.right;
//      pRootOfTree是叶子，直接返回它
        if (leftNode == null && rightNode == null) {
            return pRootOfTree;
        }
//      左子树不为空，得到重排后的左子树，并将左子树的最右节点与父节点拼接
        if (leftNode != null) {
            leftNode = Convert(leftNode);
            TreeNode leftLast = leftNode;
            while (leftLast.right != null) {
                leftLast = leftLast.right;
            }
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
//      右子树不为空，得到重排后的右子树，并将右子树的最左节点与父节点拼接
        if (rightNode != null) {
            rightNode = Convert(rightNode);
            rightNode.left = pRootOfTree;
            pRootOfTree.right = rightNode;
        }
//      如果左子树不为空，返回左子树最左节点，否则返回根节点
        if (leftNode != null) {
            return leftNode;
        } else {
            return pRootOfTree;
        }
    }

}
