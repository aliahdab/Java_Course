import java.util.Scanner;
import java.util.Random;

public class Egetspel {
	public static void main(String[] args) {

		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		int number;
		int rand = 1 + random.nextInt(50);
		while (true) {
			System.out.println("Enter a number between 1 to 50 ");
			number = scan.nextInt();

			if (number > 1 && number < 50) {
				if (number == rand) {
					System.out.println("Congratulaions you win");
					break;
				} else if (number > rand) {
					System.out.println("Your guessing number is greater");
				} else {
					System.out.println("Your guessing number is smaller");
				}

			}
		}
	}
}

