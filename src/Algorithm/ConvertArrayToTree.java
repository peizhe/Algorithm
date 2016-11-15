package Algorithm;
/**
 * 将一个数组转化成一棵树
 * 	
 * @author MG
 *
 */
public class ConvertArrayToTree {
	
	/**
	 * 数据源形式 : [1,2,3,null,null,4,5]
	 * 
	 * @param nums
	 * @return
	 */
	public static TreeNode convertToTree(String[] nums){
		if(nums == null || nums.length == 0){
			return null;
		}
		
		
		int len = nums.length;
		int[] nullCount = new int[len];
		TreeNode[] nodes = new TreeNode[len];
		
		nullCount[0] = 0;
		nodes[0] = new TreeNode(Integer.parseInt(nums[0]));
		for(int i = 1;i < len;i ++){
			nullCount[i] = nums[i] == null ? nullCount[i - 1] + 1 : nullCount[i - 1];
			
			if(nums[i] != null){
				nodes[i] = new TreeNode(Integer.parseInt(nums[i]));
			}
		}
		
		for(int i = 0;i < len;i ++){
			if(nums[i] == null){
				continue;
			}
			
			int leftIndex = 2 * (i - nullCount[i]) + 1;
			nodes[i].left = leftIndex >= len ? null : nodes[leftIndex];
			int rightIndex = 2 * (i - nullCount[i]) + 2;
			nodes[i].right = rightIndex >= len ? null : nodes[rightIndex];
		}
		
		return nodes[0];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nums = new String[]{"1","2","3",null,null,"4","5"};
		System.out.println(convertToTree(nums));
	}

}
