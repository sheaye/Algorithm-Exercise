package leetcode.graph;

import common.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * We use#as a separator for each node, and,as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph{0,1,2# 1,2# 2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by#.
 * First node is labeled as0. Connect node0to both nodes1and2.
 * Second node is labeled as1. Connect node1to node2.
 * Third node is labeled as2. Connect node2to node2(itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 * 1
 * / \
 * /   \
 * 0 --- 2
 * / \
 * \_/
 */
public class Exercise18 {

    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        if (node.neighbors == null) {
            return result;
        }
        result.neighbors = new ArrayList<>();
        if (node.neighbors.isEmpty()) {
            return result;
        }
        map.put(node.label, result);
        for (UndirectedGraphNode n : node.neighbors) {
            result.neighbors.add(cloneGraph(n));
        }
        return result;
    }

}
