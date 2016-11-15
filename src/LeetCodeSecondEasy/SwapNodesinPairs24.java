package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * 交换链表中的奇数和偶数节点
 * 	
 * @author MG
 *
 */
public class SwapNodesinPairs24 {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        
        ListNode temp = head;
        ListNode first = head;
        ListNode second = head.next;
        
        head = second;
        
        while(first != null && second != null){
        	temp.next = second;
        	
        	first.next = second.next;
        	second.next = first;
        	
        	temp = first;
        	
        	first = first.next;
        	if(first != null){
        		second = first.next;
        	}
        }
        
        return head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
