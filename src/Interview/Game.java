package Interview;

public class Game {
	public static int game(int first,int second){
		int[] map = new int[32];
		
		if(first > 1024 || second > 1024){
			return -1;
		}
		
		first -= 1;
		second -= 1;
		
		int shang1 = first / 32;
		int yushu1 = first % 32;
		int first1 = map[shang1] | (1 << (yushu1 - 1));
		System.out.println(first1);
		
		int shang2 = second / 32;
		int yushu2 = second % 32; 		
		int second2 = (map[shang2] >> (yushu2 - 1)) & 1;
		
		if(second2 == 1){
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(game(1024,1024));
	}

}
