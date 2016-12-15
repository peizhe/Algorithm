package Leetcode;
/**
 * 思想：
 * 可以通过快慢指针找一个链表的中心，
 * 
 * 将链表的后半部分进行翻转，再和前半部分进行一一比较
 */
public class PalindromeLinkedList{
	
	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		
		ListNode fast,slow;
		fast = slow = head;
		//寻找链表中心
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast == null){
			slow = reverseList(slow);
		}
		else{
			slow.next = reverseList(slow.next);
			slow = slow.next;
		}
		
		while(slow != null){
			if(head.val != slow.val){
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		
        return true;
    }
	
	//这个方法简直无法想象，太巧了！，一次循环搞定
	public static ListNode reverseList1(ListNode head) {  
        if(head==null || head.next==null) return head;  
          
        ListNode pre = head;  
        ListNode p = head.next;  
        pre.next = null;  
        ListNode nxt;  
        
        while(p != null) {  
            nxt = p.next;  
            p.next = pre;  
            pre = p;  
            p = nxt;  
        }  
        return pre;  
    }  
	
	//这个递归的方法也很巧！
	public static ListNode reverseList (ListNode head) {  
        if(head==null) return null;  
        if(head.next==null) return head;  
          
        ListNode p = head.next;  
        ListNode n = reverseList(p);  
          
        head.next = null;  
        p.next = head;  
        return n;  
    }  
	
	public static void main(String mh){
		
	}
}
