package Algorithm;

import java.util.Stack;

/**
 * ������������: ǰ��Ϊѹ������,�����ǵ�������
 * 	�жϵ��������Ƿ�Ϸ�
 * 
 * @author Administrator
 *
 */
public class StackPushAndPop {

	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
			return false;
		
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
				stack.pop();
				popIndex++;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
