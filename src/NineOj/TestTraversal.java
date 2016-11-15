package NineOj;

//1078：二叉树遍历,知道前序遍历和中序遍历，求后序遍历
import java.io.*;
import java.util.*;

public class TestTraversal {
	public static void BehindOrder(char[] preOrder, int preOrderTempIndex,
			char[] inOrder, int inOrderTempIndex, int len) {
		if (len == 0) {
			return;
		}
		char root = preOrder[preOrderTempIndex];

		int rootIndex = 0;
		for (; rootIndex < len; rootIndex++) {
			if (inOrder[rootIndex] == root) {
				break;
			}
		}
		// left
		BehindOrder(preOrder, preOrderTempIndex + 1, inOrder, 0, rootIndex);
		// right
		BehindOrder(preOrder, preOrderTempIndex + rootIndex + 1, inOrder,
				rootIndex + 1, len - (rootIndex + 1));
		System.out.print(root);
	}

	public static void main(String[] mh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		ArrayList<ArrayList<String>> ls = new ArrayList<ArrayList<String>>();
		do {
			s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(s);
				temp.add(br.readLine());
				ls.add(temp);
			}
		} while (true);

		for (int i = 0; i < ls.size(); i++) {
			char[] ch = ls.get(i).get(0).toCharArray();
			char[] ch1 = ls.get(i).get(1).toCharArray();
			BehindOrder(ch, 0, ch1, 0, ch.length);
		}
	}
}