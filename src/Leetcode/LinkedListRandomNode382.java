package Leetcode;

import java.util.Random;
/**
 * 蓄水池抽样算法！研究一下：池之中的数为最后返回的数
 * 	随机性表现在：每个数被取到的概率为k / n
 * 	这里k = 1,即每次随机生成的数为i时，则将此值与池子里的值交换
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
		//必须循环完毕，不然每个数被抽到的概率不为1 / n
		for (int i = 1;c.next != null;i ++) {
			c = c.next;
			if (random.nextInt(i + 1) == i)
				r = c.val;
		}
		return r;
	}
}
