package JavaRevisited;

public class Q11_RecursiveFibo {
	public static long fibo(long n, long c, long x, long y) {
		c++;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == c)
			return x;
		return fibo(n, c + 1, y, x + y);
	}

	public static long fibo(long n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fibo(n - 1) + fibo(n - 2);
	}

	static int c = 0;

	public static void overflow() {
		c++;
		
		overflow();
		System.out.print(c);
		
	}

	public static void main(String... arg) {
		try {
			overflow();
		} catch (StackOverflowError e) {
			System.out.println(c);
		}

		
//		try {
//			System.out.println(fibo(20000000000000L, 0, 0, 1));
//		} catch (StackOverflowError e) {
//			System.out.println(c);
//		}

		// System.out.println(fibo(15000L));
		// 
		
	}
}
