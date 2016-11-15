package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * 删除有序链表中的重复元素
 * 	1.set集合搞定
 *  2.循环一遍，删除重复元素
 *  3.栈实现
 * @author MG
 *
 */
public class RemoveDuplicatesfromSortedList83 {
	
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }
        ListNode current = head;
        
        //记录标准节点
        ListNode temp = head;
        while(current.next != null){
        	//后一个节点和前一个节点值相同，则直接将重复节点删除
        	if(current.next.val == temp.val){
        		current.next = current.next.next;
        	}
        	//后一个节点和前一个节点值不相同，则需要向后移动
        	else{
        		temp = temp.next;
        		current = temp;
        	}
        }
        
        return head;
    }

}
