package leetcode.linkedlist;

import common.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class Exercise13 {

    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(-1);
        Exercise13 exe = new Exercise13();
        exe.copyRandomList(node);
    }

    private Map<RandomListNode, RandomListNode> mMap = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode copy = new RandomListNode(head.label);
        RandomListNode copyCur = copy;
        mMap.put(head, copyCur);
        RandomListNode sourceCur = head.next;
        while (sourceCur != null) {
            copyCur.next = new RandomListNode(sourceCur.label);
            copyCur = copyCur.next;
            mMap.put(sourceCur, copyCur);
            sourceCur = sourceCur.next;
        }
        for(Map.Entry<RandomListNode, RandomListNode> m: mMap.entrySet()){
            m.getValue().random = mMap.get(m.getKey().random);
        }
        /*sourceCur = head;
        copyCur = copy;
        while (copyCur != null) {
            if (sourceCur.random != null) {
                copyCur.random = mMap.get(sourceCur.random);
            }
            copyCur = copyCur.next;
        }*/
        return copy;
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode cur = head;
//      复制新节点，并插入到原节点后面
        while (cur != null) {
            RandomListNode temp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = temp;
            cur = temp;
        }
//      赋值random
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
//      取出copy
        RandomListNode copy = head.next;
        cur = copy;
        while (cur != null && cur.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return copy;
    }

}
