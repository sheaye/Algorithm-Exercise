package offer66;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Exercise59 {


    public static void main(String[] args) {
        Exercise59 exe = new Exercise59();
        TreeNode pRoot = TreeNode.createTreeNode("8,6,10,5,7,9,11");
        ArrayList<ArrayList<Integer>> list = exe.Print(pRoot);
        System.out.println(list.toString());
    }

    private ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private Stack<TreeNode> stack1 = new Stack<>();
    private Stack<TreeNode> stack2 = new Stack<>();

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return list;
        }
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack2.isEmpty()) {
                clearStack2();
            }
            if(!stack1.isEmpty()){
                clearStack1();
            }
        }
        return list;
    }

    private void clearStack1() {
        ArrayList<Integer> item = new ArrayList<>();
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            item.add(node.val);
            if (node.left != null) {
                stack2.push(node.left);
            }
            if (node.right != null) {
                stack2.push(node.right);
            }
        }
        if (item.size() > 0) {
            list.add(item);
        }
    }

    private void clearStack2() {
        ArrayList<Integer> item = new ArrayList<>();
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            item.add(node.val);
            if (node.right != null) {
                stack1.push(node.right);
            }
            if (node.left != null) {
                stack1.push(node.left);
            }
        }
        if (item.size() > 0) {
            list.add(item);
        }
    }



    /*private int count;
    private int line;

    private ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> test = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        ArrayList<Integer> item0 = new ArrayList<>();
        item0.add(pRoot.val);
        list.add(item0);
        test.add(pRoot.val);
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty()) {
            if (count == 0) {
                count = (int) Math.pow(2, ++line);
            }
            TreeNode node = stack1.pop();
            if (line % 2 == 1) {
                pushNode(test,stack1,node.left,node.right);
            }else {
                pushNode(test,stack1,node.right,node.left);
            }
        }
        System.out.println(test.toString());
        return null;
    }

    private void pushNode(ArrayList<Integer> test, Stack<TreeNode> stack1, TreeNode node1, TreeNode node2) {
        if (node1 != null) {
            test.add(node1.val);
            stack1.push(node1);
        }
        if (node2 != null) {
            test.add(node2.val);
            stack1.push(node2);
        }
        count -= 2;
    }*/




    /*private int count;
    private ArrayList<Integer> test = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int line = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (count == 0) {
                count = (int) Math.pow(2, ++line);
            }

            System.out.println(test.toString());
            if (line % 2 != 0) {
                offerNode(queue, node.left, node.right);
            } else {
                offerNode(queue, node.right, node.left);
            }
        }
        System.out.println(test.toString());
        return null;
    }

    private void offerNode(Queue<TreeNode> queue, TreeNode node1, TreeNode node2) {
        if (node1 != null) {
            test.add(node1.val);
            queue.offer(node1);
        }
        if (node2 != null) {
            test.add(node2.val);
            queue.offer(node2);
        }
        count -= 2;
    }*/

}
