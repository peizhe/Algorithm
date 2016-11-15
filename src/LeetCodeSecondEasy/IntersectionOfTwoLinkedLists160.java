package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * ����������Ľ��㣺
 * 	1.����������ĳ��ȣ�Ȼ���ó��������߳��Ȳ��Ȼ������������ͬʱ�ߣ��ж��Ƿ��н���
 * 	2.������ķ���(����)��
 * 		You can prove that: say A length = a + c, B length = b + c, 
 * 		after switching pointer, pointer A will move another b + c steps, pointer B will move a + c more steps, 
 * 		since a + c + b + c = b + c + a + c, it does not matter what value c is. 
 * 		Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL
 * @author MG
 *
 */
public class IntersectionOfTwoLinkedLists160 {
	
	//�������̫����
	public ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB){
		//boundary check
	    if(headA == null || headB == null) return null;
	    
	    ListNode a = headA;
	    ListNode b = headB;
	    
	    //if a & b have different len, then we will stop the loop after second iteration
	    while(a != b){
	    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }
	    
	    return a;
	}
	
	
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
        int lenA = getSize(headA);
        int lenB = getSize(headB);
        
        int diff = Math.abs(lenA - lenB);
        if(lenA > lenB){
        	while(diff > 0){
        		headA = headA.next;
        		diff --;
        	}
        }
        if(lenA < lenB){
        	while(diff > 0){
        		headB = headB.next;
        		diff --;
        	}
        }
        
        while(headA != null && headB != null){
        	if(headA == headB){
        		return headA;
        	}
        	headA = headA.next;
        	headB = headB.next;
        }
        
        return null;
    }
	
	private int getSize(ListNode head){
		int res = 0;
		while(head != null){
			res ++;
			head = head.next;
		}
		
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
