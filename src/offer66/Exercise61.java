package offer66;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Exercise61 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTreeNode("1,2,3,4,5,6,7");
        Exercise61 exe = new Exercise61();

        String s = exe.Serialize(tree);
        String s3 = exe.Serialize3(tree);

        System.out.println("s :" + s);
        System.out.println("s3:" + s3);

        System.out.println("d :" + exe.Deserialize(s).toString());
        System.out.println("d3:" + exe.Deserialize3(s3).toString());
    }

    String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            builder.append("#,");
            return builder.toString();
        }
        builder.append(root.val).append(",");
        builder.append(Serialize(root.left));
        builder.append(Serialize(root.right));
        return builder.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        if (len < 1) {
            return null;
        }
        String[] strs = str.split(",");
        return Deserialize(strs);
    }

    private int index = -1;

    private TreeNode Deserialize(String[] strs) {
        index++;
        System.out.println(index);
        if (index > strs.length - 1) {
            return null;
        }
        String cur = strs[index];
        TreeNode node = null;
        if (!"#".equals(cur)) {
            node = new TreeNode(Integer.valueOf(cur));
            node.left = Deserialize(strs);
            node.right = Deserialize(strs);
        }
        return node;
    }

    public int index3 = -1;

    String Serialize3(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize3(root.left));
        sb.append(Serialize3(root.right));
        return sb.toString();
    }

    TreeNode Deserialize3(String str) {
        index3++;
        int len = str.length();
        if (index3 >= len) {
            return null;
        }
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index3].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index3]));
            node.left = Deserialize3(str);
            node.right = Deserialize3(str);
        }

        return node;
    }


    String Serialize2(TreeNode root) {
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

    TreeNode Deserialize2(String str) {
        if (str == null) {
            return null;
        }
        String[] strs = str.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        String cur = null;
        while (!queue.isEmpty() && i < strs.length) {
            TreeNode node = queue.poll();
            cur = strs[i++];
            if (!"#".equals(cur)) {
                node.left = new TreeNode(Integer.valueOf(cur));
                queue.offer(node.left);
            } else {
                node.left = null;
            }
            if (i < str.length()) {
                cur = strs[i++];
                if (!"#".equals(cur)) {
                    node.right = new TreeNode(Integer.valueOf(cur));
                    queue.offer(node.right);
                } else {
                    node.right = null;
                }
            }
        }
        return root;
    }

}
