package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * ����һ�������Ƿ���ڻ���
 * 	1.����ָ��
 * @author MG
 *
 */
public class LinkedListCycle141 {
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null){
			return false;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow){
				return true;
			}
		}
		
		return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
