package LeetCodeSecondEasy;

import Structure.ListNode;

public class PalindromeLinkedList234 {
	
	
	public boolean isPalindromeBetter(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        
        ListNode p3 = p1.next;
        ListNode pre = p1;
        //find mid pointer, and reverse head half part
        while(p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            
            pre = p1;
            p1 = p3;
            p3 = p3.next;
            p1.next = pre;
        }

        //odd number of elements, need left move p1 one step
        if(p2.next == null) {
            p1 = p1.next;
        }
        
        //compare from mid to head/tail
        while(p3 != null) {
            if(p1.val != p3.val) {
                return false;
            }
            p1 = p1.next;
            p3 = p3.next;
        }
        return true;
    }
	
	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode middle = reverse(slow);
		while(head != null && middle != null){
			if(head.val != middle.val){
				return false;
			}
			head = head.next;
			middle = middle.next;
		}
		
		return true;
    }
	
	//反转后半部分链表
	private static ListNode reverse(ListNode head){
		ListNode res = head;
		ListNode tempHead = head.next;
	
		res.next = null;	
		while(tempHead != null){
			ListNode temp = res;
			
			res = tempHead;
			tempHead = tempHead.next;
			res.next = temp;
		}
		
		return res;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
//		ListNode l5 = new ListNode(1);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
//		l4.next = l5;
		
		System.out.println(isPalindrome(l1));
	}

}
