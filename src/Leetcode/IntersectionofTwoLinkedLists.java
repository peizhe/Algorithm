package Leetcode;
//����������Ľ���㣬ֻ��valֵ��ͬ�Ϳ���
public class IntersectionofTwoLinkedLists {
	public class ListNode{
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
		{
			return null;
		}
		int lenA = getLength(headA);
		int lenB = getLength(headB);
		int diff = Math.abs(lenA - lenB);
		if(lenA > lenB)
		{
			while(diff > 0){
				headA = headA.next;
				diff --;
			}
		}
		else
		{
			while(diff > 0)
			{
				headB = headB.next;
				diff --;
			}
		}
		while(headA != null)
		{
			if(headA.val == headB.val)
			{
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
	public int getLength(ListNode head)
	{
		int res = 0;
		while(head != null)
		{
			res ++;
			head = head.next;
		}
		return res;
	}
}
