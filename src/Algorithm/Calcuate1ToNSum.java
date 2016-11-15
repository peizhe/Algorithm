package Algorithm;
//计算从1到n的和，不适用乘法，除法，循环，判断，switch，? :
public class Calcuate1ToNSum {
	static int n = 0;
	static int sum = 0;
	
	//这样可以实现一个类被实例化max次(但是用了if语句)
	public Calcuate1ToNSum(int max){
		sum += n;
		n ++;
		
		if(n <= max){
			new Calcuate1ToNSum(max);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Calcuate1ToNSum(10);
		
		System.out.println(Calcuate1ToNSum.sum);
	}
}
