package Leetcode;
/**
 * 记住ListNode first = head;这种当first指针移动时，head的指针不会动
 * @author MG
 *
 */
public class ImportantSwapNodesinPairs {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		//第一个节点
        ListNode first = head;
        //第二个节点
        ListNode second = head.next;
        
        ListNode temp = head;
        
        head = second;
        
        while(first != null && second != null){
        	//为了保证链不断，第一次循环用不到，后面循环会用到
        	temp.next = second;
        	//交换
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
	
	
}

