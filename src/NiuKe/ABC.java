package NiuKe;

import java.util.Scanner;

public class ABC {
	public static int[] getABC(int a, int b, int c, int d) {
        int[] res = new int[3];
        
        
        float B1 = (c - a) / 2, B2 = (b + d) / 2;
        if(B1 != B2) return null;
        
        res[1] = (int)B1;
        res[0] = a + res[1];
        res[2] = d - res[1];
        
        return res;
    }
    
    public static void main(String[] mh) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        
        int[] res = getABC(a,b,c,d);
        
        if(res == null) System.out.println("No");
        
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}
