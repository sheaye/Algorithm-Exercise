package offer66;

import common.RandomListNode;

import java.util.HashMap;

/**
 * 复杂链表的复制：
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 测试用例：{1,2,3,4,5,3,5,#,2,#}
 * 对应输出：{1,2,3,4,5,3,5,#,2,#}
 */
public class Exercise25 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
//      复制pHead的每个next节点到newList，并将两个链表的元素一一对应。
        RandomListNode newList = new RandomListNode(pHead.label);
        nodeMap.put(pHead, newList);

        RandomListNode currentNew = newList;
        RandomListNode currentSource = pHead.next;
        while (currentSource != null) {
            currentNew.next = new RandomListNode(currentSource.label);
            nodeMap.put(currentSource, currentNew.next);
            currentSource = currentSource.next;
            currentNew = currentNew.next;
        }
//      赋值每个random
        currentSource = pHead;
        currentNew = newList;
        while (currentSource != null) {
            currentNew.random = nodeMap.get(currentSource.random);
            currentNew = currentNew.next;
            currentSource = currentSource.next;
        }
        return newList;
    }

    public RandomListNode clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currNode = pHead;
//      根据原链表的各节点label值创建新节点，并插入到原链表的相应节点之后
//      例如原链表：A, B, C...; 插入后：A, A', B, B', C, C'...
        while (currNode != null) {
//          以源链表的当前节点的label值创建新节点
            RandomListNode node = new RandomListNode(currNode.label);
//          将原链表的下一节点赋值给新节点的next
            node.next = currNode.next;
//          将新节点赋值原链表当前节点的next
            currNode.next = node;
//          遍历到原链表的下一节点
            currNode = node.next;
        }

//      遍历赋值random
        currNode = pHead;
        while (currNode != null) {
//          新节点,比如currNode为A, 这里的node为A'
            RandomListNode node = currNode.next;
            if (currNode.random != null) {
//          由于链表中每一个原节点后面紧随着一个复制版
//          假设A的random是C，那么C随后的C’即使A'的random
                node.random = currNode.random.next;
            }
//          遍历到原链表下一个节点
            currNode = node.next;
        }
        
//        提取复制的结果
        //拆分
        RandomListNode pCloneHead = pHead.next;
        RandomListNode temp;
        currNode = pHead;
        while(currNode.next!=null){
            temp = currNode.next;
            currNode.next =temp.next;
            currNode = temp;
        }
        return pCloneHead;
    }

}
