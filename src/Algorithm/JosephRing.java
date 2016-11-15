package Algorithm;

public class JosephRing {
	//约瑟夫环问题
	//一种方法是模拟一个环状数据结构，每次删除第m个元素，这样的方法每次删除需要m步，一共需要删除n - 1个数字，所以时间复杂度是O(mn),并且空间复杂度是O(n)
	
	//下面是一种很牛的方法(时间复杂度是O(n),空间复杂度是O(1)) 每次从0,1,2....n - 1中删除第m个数
	/**
	 * f(n,m)代表每次在n个数字0,1,2,3...n - 1中每次删除第m个数字之后最后剩下的数字(只是一个数字)
	 * 
	 * 当有1个人时:最后自杀的的人的序号是0
	 * 当有2个人时:因为1个人时最后自杀的是0,则2个人最后自杀的是 (0 + m) % 2 : 因为0是上一轮最后自杀的，则(0 + m) % 2 比 0后自杀,
	 * 	人数总量只增加了1个,所以(0 + m) % 2是最后自杀也是最后剩下来的数字
	 * 当有3个人时:因为有2个人时最后保留下来的已知(设为x),则(x + m) % 3为3个人最后保留下来的
	 * ....
	 * 
	 * 			  0             		n = 1(n = 1 )
	 * f(n,m) = {
	 * 			  (f(n - 1,m) + m) % n	n > 1
	 * 
	 * n代表n个数字，m代表每次删除第m个元素
	 * 也可以当下标来使用
	 */
	public int joseRing(int n,int m){
		if(n < 1 || m < 1){
			return -1;
		}
		
		int last = 0;
		for(int i = 2;i <= n;i ++){
			//这里除的是i,不是n
			last = (last + m) % i; 
		}
		
		return last;
	}
	
	public static void main(String[] mh){
		JosephRing jr = new JosephRing();
		System.out.println(jr.joseRing(100, 6));
	}
}
