package amazon.easy;

/**
 * Created by admin on 2018/1/26.
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStack {
    /** initialize your data structure here. */
    public MinStack() {

    }

    class Element {
        final int value;

        final int min;

        Element(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }


    Stack<Element> stack = new Stack<>();

    public void push(int x) {

        final int min = (stack.isEmpty())?x:Math.min(stack.peek().min,x);

        stack.push(new Element(x,min));

    }

    public void pop() {

        stack.pop();

    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }


}
