import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Dice {
	public static void main(String[] args) {
		int[] count = new int[6];
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number of times ");
		int x = scan.nextInt();
		///long time1 = System.currentTimeMillis();
		Random r = new Random();
		int myrand;
		for (int i = 0; i < x; i++) {
			myrand = r.nextInt(6);
			count[myrand]++;
		}
		for (int i = 0; i < 6; i++) {
			System.out.println("The result of dice " + (i + 1) + "  " + (double) count[i] * 100 / x + "%");

		}

		///System.out.println(System.currentTimeMillis() - time1);
	}
}
