package LeetCodeSecondMedium;

public class BitwiseANDOfNumbersRange201 {
	public int rangeBitwiseAndBetter(int m, int n) {
		//ÿ������n�����һλ1
        while(n > m) n &= n - 1;
        
        return n;
    }
	
	public int rangeBitwiseAnd(int m, int n) {
        if(m == 0 || m == n) return m;
        
        //��С�������λ
        int maxBitM = Integer.highestOneBit(m);
        //����������λ
        int maxBitN = Integer.highestOneBit(n);
        
        int res = 0;
        while(maxBitM == maxBitN) {
        	res |= maxBitM;
        	
        	m -= maxBitM;
        	n -= maxBitN;
        	
        	maxBitM = Integer.highestOneBit(m);
        	maxBitN = Integer.highestOneBit(n);
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
