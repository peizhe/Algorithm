package Leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
//这个方法实在是太巧了！
public class ConvertSortedListtoBinarySearchTree {
	ListNode tempHead;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int length = getLength(head);
		tempHead = head;
		
		TreeNode res = buildTree(0, length - 1);
		
		return res;
	}

	public TreeNode buildTree(int begin, int end) {
		if (begin > end) {
			return null;
		}
		int mid = begin + (end - begin) / 2;
		TreeNode left = buildTree(begin, mid - 1);
		
		TreeNode root = new TreeNode(tempHead.val);
		tempHead = tempHead.next;
		
		TreeNode right = buildTree(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}

	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
}
