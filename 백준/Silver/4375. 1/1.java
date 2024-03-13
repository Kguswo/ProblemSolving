import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static long n, digit, targetnum;
	static BigInteger biginteger;
	static List<Long> numlist;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		numlist = new ArrayList<Long>();

		while (sc.hasNextLong()) {
			n = sc.nextLong();
			numlist.add(n);
		}
		for (long n : numlist) {
			digit = 0;
			targetnum = 0;
			biginteger = new BigInteger("1");
			checkdigit(n);
			System.out.println(digit);
		}
	}

	private static void checkdigit(long num) {
		BigInteger dividenum = new BigInteger(String.valueOf(num));
		
		if (num == 0)
			return;
		else {
			while (true) {
				targetnum = 0;
				digit++;

				if(biginteger.remainder(dividenum).equals(BigInteger.ZERO)) break;
				biginteger = biginteger.multiply(BigInteger.TEN).add(BigInteger.ONE);

			}
		}
	}
}
