package polygon;

public class test {
	public static void countdown(int n) {
		if (n == 0) {
			System.out.println("Blastoff!");
		} else {
			System.out.println(n);
			countdown(n - 1);
		}
	}

	public static void countup(int n) {
		if (n == 0) {
			System.out.println("Blastoff!");
		} else {
			countup(n - 1);
			System.out.println(n);
		}
	}
	public static void countdown1(int n) {
		while (n > 0) {
		System.out.println(n);
		n = n - 1;
		}
		System.out.println("Blastoff!");
		}

	public static void main(String[] args) {
		countdown1(10);

	}
}