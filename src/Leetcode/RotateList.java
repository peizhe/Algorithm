package Leetcode;
/**
 * 首尾相连形成一个环，指针从head开始后移，后移len - （k % len） - 1长度后的节点为temp，则temp.next为新链的起点
 * @author MG
 *
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k == 0){
			return head;
		}
		
		int len = 1;
		/*形成一个环*/
        ListNode temp = head;
        //找到最后一个节点
        while(temp.next != null){
        	len ++;
        	temp = temp.next;
        }
        temp.next = head;
		
		//每移动链表长度则和原来相同(k == 0不要多手就返回，要记得把把环断开)
        k = k % len;

        //右移的长度
        int rightMoveLength = len - k;
        while(rightMoveLength > 0){
        	temp = temp.next;
        	rightMoveLength --;
        }
        //右移后的节点的next即为所求链的初始节点
        head = temp.next;
        //剪断环
        temp.next = null;
        
        return head;
	}
}

