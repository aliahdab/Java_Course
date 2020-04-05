import java.util.Scanner;

public class Rot13_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			c = Encrypter.encrypt(c);
			System.out.print(c);
		}
		System.out.println();
	}
}