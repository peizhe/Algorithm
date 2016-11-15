package LeetCodeSecondEasy;

import java.util.Stack;

public class ImplementQueueusingStacks232 {
	private Stack<Integer> st1 = new Stack<Integer>();
	private Stack<Integer> temp = new Stack<Integer>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        st1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	while(!empty()){
    		temp.add(st1.pop());
    	}
    	@SuppressWarnings("unused")
		int res = temp.isEmpty() ? -1 : temp.pop();
    	while(!temp.isEmpty()){
    		st1.add(temp.pop());
    	}
    	
    }

    // Get the front element.
    public int peek() {
        return st1.get(0);
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st1.isEmpty();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
