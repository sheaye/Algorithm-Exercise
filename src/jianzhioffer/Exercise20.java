package jianzhioffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 栈：后进先出
 */
public class Exercise20 {

    //    ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        System.out.print(stack.min());
    }

    public static class MyStack {

        private Stack<Integer> mElements = new Stack<>();
        private Stack<Integer> mMinStack = new Stack<>();

        public void push(int node) {
            mElements.push(node);
            if (mMinStack.empty()) {
                mMinStack.push(node);
            } else {
                int min = min();
                if (node <= min) {
                    mMinStack.push(node);
                } else {
                    mMinStack.push(min);
                }
            }
        }

        public void pop() {
            mElements.pop();
            mMinStack.pop();
        }

        public int top() {
            return mElements.peek();
        }

        public int min() {
            return mMinStack.peek();
        }

    }

    public static class MyStack2 {

        private int[] mElements = new int[10];
        private int mSize;
        private int mMin = Integer.MAX_VALUE;
        private Stack<Integer> mMinStack = new Stack<>();

        public void push(int node) {
            ensureCapacity();
            mElements[mSize++] = node;
            if (node <= mMin) {
                mMinStack.push(node);
                mMin = node;
            } else {
                mMinStack.push(mMin);
            }
            System.out.print(mMinStack.toString());
        }

        private void ensureCapacity() {
            int capacity = mElements.length;
            if (capacity == mSize) {
                int newCapacity = (capacity * 3) / 2 + 1;
                mElements = Arrays.copyOf(mElements, newCapacity);
            }
        }

        public void pop() {
            Integer top = top();
            if (top != null) {
                mElements[mSize - 1] = Integer.parseInt(null);
            }
            mSize--;
            mMinStack.pop();
            mMin = mMinStack.peek();
        }

        public int top() {
            if (empty()) {
                return Integer.parseInt(null);
            }
            if (mSize - 1 > 0) {
                return mElements[mSize - 1];
            }
            return Integer.parseInt(null);
        }

        public int min() {
            return mMin;
        }

        public boolean empty() {
            return mSize == 0;
        }
    }

    public class MyStack3 {

        private int size;
        private int min = Integer.MAX_VALUE;
        private Stack<Integer> minStack = new Stack<Integer>();
        private Integer[] elements = new Integer[10];

        public void push(int node) {
            ensureCapacity(size + 1);
            elements[size++] = node;
            if (node <= min) {
                minStack.push(node);
                min = minStack.peek();
            } else {
                minStack.push(min);
            }
            //    System.out.println(min+"");
        }

        private void ensureCapacity(int size) {
            // TODO Auto-generated method stub
            int len = elements.length;
            if (size > len) {
                int newLen = (len * 3) / 2 + 1; //每次扩容方式
                elements = Arrays.copyOf(elements, newLen);
            }
        }

        public void pop() {
            Integer top = top();
            if (top != null) {
                elements[size - 1] = (Integer) null;
            }
            size--;
            minStack.pop();
            min = minStack.peek();
            //    System.out.println(min+"");
        }

        public int top() {
            if (!empty()) {
                if (size - 1 >= 0)
                    return elements[size - 1];
            }
            return (Integer) null;
        }

        public boolean empty() {
            return size == 0;
        }

        public int min() {
            return min;
        }
    }
}

