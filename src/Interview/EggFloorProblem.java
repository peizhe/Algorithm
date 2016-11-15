package Interview;

/**
 * 既然第一步（确定临界段）的投掷数增加不可避免，我们就让第二步（确定临界层）的投掷数随着第一步的次数增加而减少。
 * 第一步的投掷数是一次一次增加的，那就让第二步的投掷数一次一次减少。
 * 假设第一次投掷的层数是f，转化成数学模型，f + (f-1) +... + 2 + 1就表示从f开始猜，每次的增量都比前一次的曾量减1的情况下，最后猜的那个数(即 f + (f - 1) +...+ 2 + 1)
 * 按照提议要求f + (f - 1) +...+ 2 + 1 >= 99，即f(f + 1) / 2 >= 99
 * (第一次测试点选择100层是无意义的，必然会碎，所以无任何测试价值，所以第一次测试点k是1 - 99中的一个数)，
 * 解出结果等于14。
 */
public class EggFloorProblem {
	
	public static int eggFloor(int floorHeight){
		int sum = 1,index = 1;
		while(sum < floorHeight){
			index ++;
			sum += index;
		}
		
		return index;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(eggFloor(100));
	}

}
