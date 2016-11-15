package Leetcode;
/**
 * ��סListNode first = head;���ֵ�firstָ���ƶ�ʱ��head��ָ�벻�ᶯ
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
		
		//��һ���ڵ�
        ListNode first = head;
        //�ڶ����ڵ�
        ListNode second = head.next;
        
        ListNode temp = head;
        
        head = second;
        
        while(first != null && second != null){
        	//Ϊ�˱�֤�����ϣ���һ��ѭ���ò���������ѭ�����õ�
        	temp.next = second;
        	//����
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

