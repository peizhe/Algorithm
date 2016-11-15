package LeetCodeSecondEasy;
/**
 * 看看大神们的代码！
 * @author MG
 *
 */
public class MinStack155 {
	private Node head;
    
    public void push(int x) {
        if(head == null) 
            head = new Node(x, x);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min) {
            this(val, min, null);
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack155 ms = new MinStack155();
		ms.push(-2);
		ms.push(0);
		ms.push(-1);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
	}

}
