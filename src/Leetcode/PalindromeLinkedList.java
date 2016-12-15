package Leetcode;
/**
 * ˼�룺
 * ����ͨ������ָ����һ����������ģ�
 * 
 * ������ĺ�벿�ֽ��з�ת���ٺ�ǰ�벿�ֽ���һһ�Ƚ�
 */
public class PalindromeLinkedList{
	
	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		
		ListNode fast,slow;
		fast = slow = head;
		//Ѱ����������
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
	
	//���������ֱ�޷�����̫���ˣ���һ��ѭ���㶨
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
	
	//����ݹ�ķ���Ҳ���ɣ�
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
