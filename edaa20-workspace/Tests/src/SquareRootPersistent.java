import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SquareRootPersistent {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("/home/ali/eclipse-workspace/edaa20-workspace/Tests/src/numbers.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file numbers.txt");
			System.exit(1);
		}
		PrintWriter output = null;
		try {
			output = new PrintWriter(new File("/home/ali/eclipse-workspace/edaa20-workspace/Tests/src/result.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file result.txt");
			System.exit(1);
		}
		while (scanner.hasNextDouble()) {
			double d = scanner.nextDouble();
			output.println(Math.sqrt(d));
		}
		output.close();
	}
}
