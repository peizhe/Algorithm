package Leetcode;
/**
 * 解决方法 :
 * 	1.快慢指针方法求得链表的中间节点(链表长度是奇数恰为中间那个,链表长度为偶数则为(长度 / 2 + 1)那个节点)
 * 	2.将后半部分链表进行翻转
 * 	3.合并前半部分链表和后半部分链表	
 * 
 * @author MG
 *
 */
public class ReorderList143 {
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
        	return;
        }
        
        ListNode fast = head, slow = head, preSlow = head;
        while(fast != null && fast.next != null){
        	preSlow = slow;
        	
        	slow = slow.next;
        	fast = fast.next.next;
        }
        //将链表分段
        preSlow.next = null;
        
        //将后半部分翻转,postHead是翻转后的头结点
        ListNode postHead = null;
        
        while(slow != null){
        	ListNode temp = slow;
        	slow = slow.next;
        	
        	temp.next = postHead;
        	postHead = temp;
        }
        
        ListNode temp = head;
        ListNode preHead = head.next;
        boolean flag = false;//true在head中取节点,false在postHead中取节点
        while(preHead != null || postHead != null){
        	if(preHead == null){
        		temp.next = postHead;
        		break;
        	}
        	
        	if(flag){
        		temp.next = preHead;
        		preHead = preHead.next;
        	} else {
        		temp.next = postHead;
        		postHead = postHead.next;
        	}
        	
        	flag = !flag;
        	temp = temp.next;
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		head.next = node1;
		node1.next = node2;
		
		reorderList(head);
	}

}
