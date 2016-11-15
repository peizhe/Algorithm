package Leetcode;

import java.util.Random;
/**
 * ��ˮ�س����㷨���о�һ�£���֮�е���Ϊ��󷵻ص���
 * 	����Ա����ڣ�ÿ������ȡ���ĸ���Ϊk / n
 * 	����k = 1,��ÿ��������ɵ���Ϊiʱ���򽫴�ֵ��������ֵ����
 * @author MG
 *
 */
public class LinkedListRandomNode382 {

	ListNode head;
	Random random;

	public LinkedListRandomNode382(ListNode head) {
		this.head = head;
		random = new Random();
	}

	public int getRandom() {

		ListNode c = head;
		int r = c.val;
		//����ѭ����ϣ���Ȼÿ�������鵽�ĸ��ʲ�Ϊ1 / n
		for (int i = 1;c.next != null;i ++) {
			c = c.next;
			if (random.nextInt(i + 1) == i)
				r = c.val;
		}
		return r;
	}
}
