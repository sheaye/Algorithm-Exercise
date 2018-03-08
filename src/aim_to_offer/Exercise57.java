package aim_to_offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Exercise57 {

    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            return getNext(pNode);
        }
    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        TreeLinkNode parent = pNode.next;
        if (parent == null) {
            return null;
        }
        if (pNode == parent.right) {
            return getNext(parent);
        } else {
            return parent;
        }

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent != null && (pNode == parent.right)) {
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }


}
