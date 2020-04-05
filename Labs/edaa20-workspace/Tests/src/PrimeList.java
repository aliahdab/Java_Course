public class PrimeList {
	private boolean[] numbers;

	public PrimeList(int n) { // 2p inkl attribut
		numbers = new boolean[n + 1];
		preparePrimeList();
	}

	private void preparePrimeList() { // 7p
		for (int i = 2; i < numbers.length; i++) {
			numbers[i] = true;
		}
		int nextPrime = 2;
		while (nextPrime <= Math.sqrt(numbers.length)) {
			for (int i = nextPrime + 1; i < numbers.length; i++) {
				if (i % nextPrime == 0) {
					numbers[i] = false;
				}
			}
			int search = nextPrime + 1;
			while (search <= Math.sqrt(numbers.length) && numbers[search] == false) {
				search++;
			}
			nextPrime = search;
		}
	}

	public void printPrimeList() { // 3p
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			if (isPrime(i)) {
				sb.append(i + ", ");
			}
		}
		sb.deleteCharAt(sb.length() - 2);
		System.out.println(sb);
	}

	public boolean isPrime(int nbr) { // 2p
		if (nbr > 0 && nbr < numbers.length) {
			return numbers[nbr];
		}
		return false;
	}
}