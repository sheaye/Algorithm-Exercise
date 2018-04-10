package common;

import java.util.ArrayList;

public class UndirectedGraphNode {

    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    /**
     * 0,1,2# 1,2# 2,2
     *
     * @param node
     * @return
     */
    /*public UndirectedGraphNode createUndirectedGraphNode(String node) {
        String[] nodeArray = node.split("# ");
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode result = null;
        for (int i = 0; i < nodeArray.length; i++) {
            String[] nodes = nodeArray[i].split(",");
            for (int j = 0; j < nodeArray[i].length(); j++) {
                if (i == 0) {
                    result = new UndirectedGraphNode()
                }
            }
        }

    }*/
}
