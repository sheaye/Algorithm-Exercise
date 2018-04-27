package leetcode.search;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class Exercise24 {

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>() {
            {
                add("ted");
                add("tex");
                add("tax");
                add("tad");
                add("den");
                add("rex");
                add("pee");
            }
        };
        Exercise24 exe = new Exercise24();
        ArrayList<ArrayList<String>> ladders = exe.findLadders("red", "tax", dict);
        System.out.println(ladders.toString());
    }

    private class Node {
        String value;
        int level;
        LinkedList<Node> pre;

        public Node(String value, int level) {
            this.value = value;
            this.level = level;
        }

        private void setLevel(int level) {
            this.level = level;
        }

        private void addPre(Node node) {
            if (pre == null) {
                pre = new LinkedList<>();
            }
            pre.add(node);
        }

    }

    private ArrayList<ArrayList<String>> result;

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        result = new ArrayList<>();
        Node nodeStart = new Node(start, 0);
        Node nodeEnd = new Node(end, Integer.MAX_VALUE);
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodeStart);
        HashMap<String, Node> map = new HashMap<>();
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curLevel = curNode.level;
            if (curLevel > nodeEnd.level) {
                break;
            }
            if (isTransformEnable(curNode.value, end)) {
                nodeEnd.setLevel(curLevel + 1);
                nodeEnd.addPre(curNode);
            }
            for (String str : dict) {
                if (isTransformEnable(curNode.value, str)) {
                    Node next;
                    if (map.containsKey(str)) {
                        next = map.get(str);
                        if (curLevel > next.level) {
                            continue;
                        }
                    } else {
                        next = new Node(str, curLevel + 1);
                    }
                    next.addPre(curNode);
                    queue.add(next);
                }
            }
        }
        if (nodeEnd.level == Integer.MAX_VALUE) {
            return result;
        }
        backTrace(nodeEnd, new ArrayList<>());
        return result;
    }

    private void backTrace(Node node, ArrayList<String> item) {
        item.add(0, node.value);
        if (node.pre == null) {
            result.add(item);
        } else {
            for (Node n : node.pre) {
                backTrace(n, new ArrayList<>(item));
            }
        }
    }

    private boolean isTransformEnable(String start, String end) {
        if (start.equals(end)) {
            return false;
        }
        for (int i = 0; i < end.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                while (++i < end.length()) {
                    if (start.charAt(i) != end.charAt(i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }



}
