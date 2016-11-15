package LeetCodeSecondEasy;
/**
 * 二进制字符串相加：
 * 	1.每一位相加，判断是否大于1，大于1则进位置位1(最笨的方法)
 * 	2.每一位相加，判断是否大于1，大于1则进位置位1(细节处理，见下面代码)
 * @author MG
 *
 */
public class AddBinary67 {
	public static String addBinaryBetter(String a, String b) {
		char[] sa, sb;
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        
        sa = a.toCharArray();
        sb = b.toCharArray();
        int indexA = sa.length - 1, indexB = sb.length - 1, prev = 0, curA, curB, cur;
        while (indexA >= 0) {
            curA = sa[indexA] - '0';
            curB = indexB >= 0 ? sb[indexB] - '0' : 0;
            
            cur = curA + curB + prev;
            
            prev = cur / 2;
            sa[indexA] = (char) ('0' + cur % 2);
            
            indexA --;
            indexB --;
        }
        
        return prev == 1 ? 1 + new String(sa) : new String(sa);
	}
	
	public static String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
        	return b;
        }
        
        if(b == null || b.length() == 0){
        	return a;
        }
        String res = "";
        
        int ap = a.length() - 1;
        int bp = b.length() - 1;
        
        int ach;
        int bch;
        int currentBitRes;
        int carryBit = 0;
        
        while(ap >= 0 && bp >= 0){
        	ach = a.charAt(ap) - '0';
        	bch = b.charAt(bp) - '0';
        	
        	int temp = ach + bch + carryBit;
        	currentBitRes = temp % 2;
        	carryBit = temp / 2; 
        	
        	res = currentBitRes + res;
        	
        	ap --;
        	bp --;
        }
        
        while(ap >= 0){
        	if(carryBit == 1){
        		ach = a.charAt(ap) - '0';
            	int temp = ach + carryBit;
            	currentBitRes = temp % 2;
            	carryBit = temp / 2; 
            	
            	res = currentBitRes + res;
            	
            	ap --;
        	} else{
        		res = a.substring(0, ap + 1) + res;
        		break;
        	}
        }
        
        while(bp >= 0){
        	if(carryBit == 1){
        		bch = b.charAt(bp) - '0';
            	int temp = bch + carryBit;
            	currentBitRes = temp % 2;
            	carryBit = temp / 2; 
            	
            	res = currentBitRes + res;
            	
            	bp --;
        	} else{
        		res = b.substring(0, bp + 1) + res; 
        		break;
        	}
        }
        
        return carryBit == 1 ? 1 + res : res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "100";
		String b = "110010";
		System.out.println(addBinary(a,b));
	}

}
