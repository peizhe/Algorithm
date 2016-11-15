package LeetCodeSecondEasy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues225 {
	Queue<Integer> queue = new LinkedList<Integer>();
	
	// Push element x onto stack.
    public void push(int x) {
    	//每次把元素放在队头
        queue.add(x);
        for(int i = 0;i < queue.size() - 1;i ++){
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.remove();
    }

    // Get the top element.
    public int top() {
    	return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
