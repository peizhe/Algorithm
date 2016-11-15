package Leetcode;

import Structure.ListNode;

public class ReverseLinkedList {
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
}
