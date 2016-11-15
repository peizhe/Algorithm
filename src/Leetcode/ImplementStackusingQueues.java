package Leetcode;
//一个队列就可以实现一个栈！！！
import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
	Queue<Integer> q = new LinkedList<Integer>();
	// Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q.size();
        for(int i = 1; i < size; i++)
            q.add(q.remove());
        q.remove();
    }

    // Get the top element.
    public int top() {
        int size = q.size();
        for(int i = 1; i < size; i++)
            q.add(q.remove());
        int ret = q.remove();
        q.add(ret);
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
       return q.isEmpty();
    }
}
