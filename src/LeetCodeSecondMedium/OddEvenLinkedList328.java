package LeetCodeSecondMedium;

import Structure.ListNode;

/**
 * @author MG
 *
 */
public class OddEvenLinkedList328 {
	public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        //奇数节点
        ListNode odd = new ListNode(0);
        //偶数节点
        ListNode even = new ListNode(0);
        
        boolean flag = true;
        ListNode first = odd,second = even;
        
        while(head != null){
        	if(flag){
        		first.next = head;
        		first = first.next;
        	} else{
        		second.next = head;
        		second = second.next;
        	}
        	head = head.next;
        	flag = !flag;
        }
        
        second.next = null;
        first.next = even.next;
        
        return odd.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for(int i = 2;i < 9;i ++){
			ListNode tempListNode = new ListNode(i);
			temp.next = tempListNode;
			temp = temp.next;
		}
		
		System.out.println(oddEvenList(head));
	}

}
