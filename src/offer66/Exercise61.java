package offer66;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Exercise61 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTreeNode("1,2,3,4,5,#,#,6,#,7,8,#,#,#,#,10,11,#,#,#,#");
        Exercise61 exe = new Exercise61();
        System.out.println(exe.Deserialize(exe.Serialize(tree)).toString());
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                builder.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                builder.append("#,");
            }
        }
        return builder.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] strs = str.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < str.length()) {
            TreeNode node = queue.poll();
            if (!"#".equals(strs[i++])) {
                node.left = new TreeNode(Integer.valueOf(strs[i++]));
                queue.offer(node.left);
            }else {
                node.left = null;
            }
            if (i < str.length()) {
                if (!"#".equals(strs[i])) {
                    node.right = new TreeNode(Integer.valueOf(strs[i++]));
                    queue.offer(node.right);
                }else {
                    node.right = null;
                }
            }
        }
        return root;
    }

}
