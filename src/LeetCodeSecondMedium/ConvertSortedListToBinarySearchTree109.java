package LeetCodeSecondMedium;

import Structure.ListNode;
import Structure.TreeNode;

/**
 * 
 * 二路归并的思想
 * 
 * @author Administrator
 *
 */
public class ConvertSortedListToBinarySearchTree109 {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		
        return helper(head);
    }
	
	private TreeNode helper(ListNode head) {
		if(head == null) return null;
		else if(head.next == null) return new TreeNode(head.val);
		else {
			ListNode fast = head, slow = head, pre = head;
			while(fast != null && fast.next != null) {
				pre = slow;
				
				slow = slow.next;
				fast = fast.next.next;
			}
			
			ListNode left = head, right = slow.next;
			//将前段链断开
			pre.next = null;
			//将后段链断开
			slow.next = null;
			
			TreeNode root = new TreeNode(slow.val);
			root.left = helper(left);
			root.right = helper(right);
			
			return root;
		}
	}
}
