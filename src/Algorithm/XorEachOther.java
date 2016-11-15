package Algorithm;

public class XorEachOther {
	/**
	 * 有n个正整数，将每个整数两两异或，求出最后所有异或结果的和。n <= 1000000 , 给出的正整数 <= 1000000.
	 * 
	 * 屌炸天
	 * @param nums
	 * @return
	 *   
	 */
	public long sumXorEachOther(int[] nums){
		int len = nums.length;
		//存储每一位是1的元素的数量
		int[] map = new int[32];
		for(int i = 0;i < len;i ++){
			for(int j = 0;j < 32;j ++){
				//记录每一个数的哪些位为1
				if((nums[i] & (1 << j)) == 1){
					map[j] ++;
				}
			}
		}
		
		long res = 0;
		for(int i = 0;i < 32;i ++){
			//map[i]代表数组中所有元素在第i位一共存在多少个1
			//map[i]个1;(len - map[i])个0 。只有不同的数异或值才为1
			//所以两两异或的和 = 1的个数 * 0的个数。所以是(len - map[i]) * map[i]
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
	 * (要求输入的数都是非负数)
	 * Give n 32bit numbers which are all positive integers, 
	 * then find the two numbers that can get the maximum value after their XOR.
	 * 
	 * @param nums
	 * @return 异或的最大值，时间复杂度是O(n)
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
	
	//返回与m最匹配的数与m的异或值
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
	 * 每个节点存储经过这个点的元素数目
	 * 孩子的数量
	 * 节点的值
	 * @author MG
	 *
	 */
	class Node {
		private Node[] son;
		private int count;//经过这个节点的值
		@SuppressWarnings("unused")
		private int val;
		
		public Node(){
			count = 1;
			son = new Node[2];
		}
	}
}
