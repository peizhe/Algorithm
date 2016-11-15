package Leetcode;
/**
 * ������� :
 * 	1.����ָ�뷽�����������м�ڵ�(������������ǡΪ�м��Ǹ�,������Ϊż����Ϊ(���� / 2 + 1)�Ǹ��ڵ�)
 * 	2.����벿��������з�ת
 * 	3.�ϲ�ǰ�벿������ͺ�벿������	
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
        //������ֶ�
        preSlow.next = null;
        
        //����벿�ַ�ת,postHead�Ƿ�ת���ͷ���
        ListNode postHead = null;
        
        while(slow != null){
        	ListNode temp = slow;
        	slow = slow.next;
        	
        	temp.next = postHead;
        	postHead = temp;
        }
        
        ListNode temp = head;
        ListNode preHead = head.next;
        boolean flag = false;//true��head��ȡ�ڵ�,false��postHead��ȡ�ڵ�
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
