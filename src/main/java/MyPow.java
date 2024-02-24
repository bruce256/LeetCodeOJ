import java.io.PipedWriter;

/**
 * @author LvSheng
 * @date 2024/2/24
 **/
public class MyPow {
	
	public double myPow(double x, int n) {
		return n >= 0 ? pow(x, n) : 1.0 / pow(x, -n);
	}
	
	// 如果n是int的最小负数，那么-n依然是它自己
	private double pow(double x, long n) {
		if (n == 0) return 1;
		double y = pow(x, n / 2);
		return n % 2 == 0 ? y * y : y * y * x;
	}
	
	public static void main(String[] args) {
		MyPow test = new MyPow();
		System.out.println(test.myPow(2.00d, 10));
		System.out.println(test.myPow(2.00d, -2));
		System.out.println(test.myPow(0.00001d, 2147483647));
		System.out.println(test.myPow(2.00000d, -2147483648));
	}
}
