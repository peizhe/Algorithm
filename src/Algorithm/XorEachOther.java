package Algorithm;

public class XorEachOther {
	/**
	 * ��n������������ÿ�����������������������������ĺ͡�n <= 1000000 , ������������ <= 1000000.
	 * 
	 * ��ը��
	 * @param nums
	 * @return
	 *   
	 */
	public long sumXorEachOther(int[] nums){
		int len = nums.length;
		//�洢ÿһλ��1��Ԫ�ص�����
		int[] map = new int[32];
		for(int i = 0;i < len;i ++){
			for(int j = 0;j < 32;j ++){
				//��¼ÿһ��������ЩλΪ1
				if((nums[i] & (1 << j)) == 1){
					map[j] ++;
				}
			}
		}
		
		long res = 0;
		for(int i = 0;i < 32;i ++){
			//map[i]��������������Ԫ���ڵ�iλһ�����ڶ��ٸ�1
			//map[i]��1;(len - map[i])��0 ��ֻ�в�ͬ�������ֵ��Ϊ1
			//�����������ĺ� = 1�ĸ��� * 0�ĸ�����������(len - map[i]) * map[i]
			res += (len - map[i]) * map[i] * (1 << i);
		}
		
		return res;
	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XorEachOther xeo = new XorEachOther();
		int[] nums = new int[]{1,2,-3,-4};
		System.out.println(xeo.maxXorEachOther(nums));
	}
	
	/**
	 * find the max value after XORing?
	 * (Ҫ������������ǷǸ���)
	 * Give n 32bit numbers which are all positive integers, 
	 * then find the two numbers that can get the maximum value after their XOR.
	 * 
	 * @param nums
	 * @return �������ֵ��ʱ�临�Ӷ���O(n)
	 */
	public int maxXorEachOther(int[] nums){
		Node root = new Node();
		int len = nums.length;
		for(int i = 0;i < len;i ++){
			insert(root, nums[i]);
		}
		
		int res = Integer.MIN_VALUE;
		for(int i = 0;i < len;i ++){
			int temp = bestMatch(root, nums[i]);
			res = temp > res ? temp : res; 
		}
		
		return res;
	}
	
	private void insert(Node root, int x) {  
	    Node node = root;
	    for(int i = 30;i >= 0;i --) {  
	        int bit = (x & (1 << i)) == 0 ? 0 : 1;
	        
	        if(node.son[bit] == null) {
	            node.son[bit] = new Node();
	            node.son[bit].val = bit;
	        } else{
	        	node.son[bit].count ++; 
	        }
	        
	        node = node.son[bit];
	    }
	}
	
	//������m��ƥ�������m�����ֵ
	private int bestMatch(Node root, int m){
		
		int match = 0;
		Node node = root;
		for(int i = 30;i >= 0;i --){
			int bit = (m >> i) & 1;
			if(bit == 1){
				if(node.son[0] != null){
					node = node.son[0];
				} else {
					match += (1 << i);
					node = node.son[1];
				}
			} else {
				if(node.son[1] != null){
					match += (1 << i);
					node = node.son[1];
				} else {
					node = node.son[0];
				}
			}
		}
		
		return match ^ m;
	}

	/**
	 * ÿ���ڵ�洢����������Ԫ����Ŀ
	 * ���ӵ�����
	 * �ڵ��ֵ
	 * @author MG
	 *
	 */
	class Node {
		private Node[] son;
		private int count;//��������ڵ��ֵ
		@SuppressWarnings("unused")
		private int val;
		
		public Node(){
			count = 1;
			son = new Node[2];
		}
	}
}
