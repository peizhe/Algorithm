package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * ɾ�����������е��ظ�Ԫ��
 * 	1.set���ϸ㶨
 *  2.ѭ��һ�飬ɾ���ظ�Ԫ��
 *  3.ջʵ��
 * @author MG
 *
 */
public class RemoveDuplicatesfromSortedList83 {
	
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode current = head;
        
        //��¼��׼�ڵ�
        ListNode temp = head;
        while(current.next != null){
        	//��һ���ڵ��ǰһ���ڵ�ֵ��ͬ����ֱ�ӽ��ظ��ڵ�ɾ��
        	if(current.next.val == temp.val){
        		current.next = current.next.next;
        	}
        	//��һ���ڵ��ǰһ���ڵ�ֵ����ͬ������Ҫ����ƶ�
        	else{
        		temp = temp.next;
        		current = temp;
        	}
        }
        
        return head;
    }

}
