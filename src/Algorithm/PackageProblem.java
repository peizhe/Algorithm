package Algorithm;
//使用动态规划的方法解决0-1背包问题
/**
 * 每个物品的数量只有一个(牢记这一点)
 */
public class PackageProblem {
	public static int pack(int[] weight,int[] val,int capacity){
		int cap = capacity + 1;
		int len = weight.length + 1;
		//v[i][j]表示容量为j时装入前i个物品的最大价值
		int[][] v = new int[len][cap];
		
		for(int i = 0;i < len;i ++){
			v[i][0] = 0;
		}
		for(int j = 0;j < cap;j ++){
			v[0][j] = 0;
		}
		
		for(int i = 1;i < len;i ++){
			for(int j = 1;j < cap;j ++){
				if(weight[i - 1] > j){
					//如果第i个物品的质量大于背包当前的容量，则不能装入该物品！
					v[i][j] = v[i - 1][j];
				} else{
					//如果第i个物品的质量小于背包当前容量，则需考虑两种情况：
					//（1）将第i个物品装入背包，其价值相当于将前i - 1个物品装入容量为j - weight[i]的最大价值 + 物品i的价值：v[i - 1][j - weight[i]] + val[i]
					//（2）不把第i个物品装入背包，其价值相当于将前i - 1个物品装入容量为j的最大价值：v[i - 1][j]
					v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i - 1]] + val[i - 1]);
				}
			}
		}
		
		//以下用于结果显示
		cap = capacity;
		len = weight.length;
		//存放最后装入背包的物品，装入为1，不装入为0
		int[] index = new int[len];
		for(int i = len;i > 0;i --){
			if(v[i][cap] > v[i - 1][cap]){
				index[i - 1] = 1;
				cap = cap - weight[i - 1];
			}
			else{
				index[i - 1] = 0;
			}
		} 
		
		for(int i = 0;i < index.length;i ++){
			System.out.print(index[i] + " ");
		}
		System.out.println();
		return v[len][capacity];
		
	}
	public static void main(String[] mh){
		int[] weight = {5,4,8,9,2};
		int[] val = {5,12,1,3,4};
		int capacity = 20;
		System.out.println(pack(weight,val,capacity));
	}
}
