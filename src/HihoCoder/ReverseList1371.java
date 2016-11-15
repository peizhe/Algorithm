package HihoCoder;

import java.util.Scanner;

public class ReverseList1371 {

	public static Node reverse(Node root) {
		if (root == null || root.next == null) {
			return root;
		}

		Node head = root;

		root = root.next;

		head.next = null;
		while (root != null) {
			Node temp = root;
			root = root.next;

			temp.next = head;
			head = temp;
		}

		return head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = Sc.sc;
		int n = -1;
		while (sc.hasNext() && (n = sc.nextInt()) != -1) {
			Node root = new Node();
			root.val = sc.nextInt();

			Node temp = root;
			for (int i = 1; i < n; i++) {
				Node node = new Node();
				node.val = sc.nextInt();

				temp.next = node;

				temp = temp.next;
			}

			Node res = reverse(root);

			while (res.next != null) {
				System.out.print(res.val + " ");
				res = res.next;
			}

			System.out.print(res.val);
		}
	}
}

class Node {
	int val;
	Node next;
}
