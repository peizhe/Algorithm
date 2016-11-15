package Algorithm;
//kmp算法思想！(主要是求next的方法)
public class KMP {
	
	public static void main(String[] mh){
		String s = "agctagcagctagct";
		String t = "agctagcagctagct";
		System.out.println(kmp(s,t));
	}
	
	public static int kmp(String s,String t){
		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();
		int[] next = new int[t.length()];
		
		next(tch,next);
		for(int i = 0;i < next.length;i ++){
			System.out.print(next[i] + " ");
		}
		System.out.println();
		
		int slen = sch.length;
		int tlen = tch.length;
		int i = 0,q = 0;
		
		for(;i < slen;i ++){
			
			while(q > 0 && sch[i] != tch[q]){
				q = next[q - 1];
			}
			if(sch[i] == tch[q]){
				q ++;
			}
			if(q == tlen){
				return i - tlen + 1;
			}
		}
		return -1;
	}
	
	public static void next(char[] t, int[] next){
		next[0] = 0;
		int k = 0,q = 0;
		//不断递归判断是否存在子对称，k=0说明不再有子对称，t[i] != t[k]说明虽然对称，
		//但是对称后面的值和当前的字符值不相等，所以继续递推
		for(q = 1;q < t.length;q ++){
			while(k > 0 && t[q] != t[k]){
				k = next[k - 1];//找到了这个子对称，或者是直接继承了前面的对称性，这两种都在前面的基础上++
			}
			if(t[q] == t[k]){
				k ++;
			}
			next[q] = k;//如果遍历了所有子对称都无效，说明这个新字符不具有对称性，清0
		}
	}
}
