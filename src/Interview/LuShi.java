package Interview;

public class LuShi {

	public static int maxDamage(int[] cost,int[] val,int total){
		int cap = total + 1;
		int len = cost.length + 1;
		
		int[][] v = new int[len][cap];
		
		for(int i = 0;i < len;i ++){
			v[i][0] = 0;
		}
		for(int j = 0;j < cap;j ++){
			v[0][j] = 0;
		}
		for(int i = 1;i < len;i ++){
			for(int j = 1;j < cap;j ++){
				if(cost[i - 1] > j){
					v[i][j] = v[i - 1][j];
				}
				else{
					v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - cost[i - 1]] + val[i - 1]);
				}
			}
		}
		
		return v[len - 1][cap - 1];
		
	}
	public static void main(String[] mh){
		int[] cost = {5,2,8,3};
		int[] damage = {7,3,10,4};
		int capacity = 10;
		System.out.println(maxDamage(cost,damage,capacity));
	}

}
