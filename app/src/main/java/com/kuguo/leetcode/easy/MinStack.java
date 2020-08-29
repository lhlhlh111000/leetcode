package com.kuguo.leetcode.easy;

import java.util.Stack;

/**
 * Title:
 * Description:
 * Copyright © 2001-2020 17173. All rights reserved.
 *
 * @author cqt
 * @version 2020/8/29
 */
class MinStack {

    private Stack<Integer> stack;

    private Stack<Integer> min_stack;

    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek()) {
            min_stack.push(x);
        }
    }

    public void pop() {
        if(stack.pop().equals(min_stack.peek())) {
            min_stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}
