package Algorithm;
//kmp�㷨˼�룡(��Ҫ����next�ķ���)
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
		//���ϵݹ��ж��Ƿ�����ӶԳƣ�k=0˵���������ӶԳƣ�t[i] != t[k]˵����Ȼ�Գƣ�
		//���ǶԳƺ����ֵ�͵�ǰ���ַ�ֵ����ȣ����Լ�������
		for(q = 1;q < t.length;q ++){
			while(k > 0 && t[q] != t[k]){
				k = next[k - 1];//�ҵ�������ӶԳƣ�������ֱ�Ӽ̳���ǰ��ĶԳ��ԣ������ֶ���ǰ��Ļ�����++
			}
			if(t[q] == t[k]){
				k ++;
			}
			next[q] = k;//��������������ӶԳƶ���Ч��˵��������ַ������жԳ��ԣ���0
		}
	}
}
