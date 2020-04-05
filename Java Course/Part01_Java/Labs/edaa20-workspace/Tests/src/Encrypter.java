
public class Encrypter {
	public static char encrypt(char c) {

		if (c >= 'A' && c <= 'M') {
			c = (char) (c + 13);
		} else if (c >= 'N' && c <= 'Z') {
			c = (char) (c - 13);
		}
		return c;
	}
	
	public static String encrypt(String s) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i <s.length();i++) {
			char c = s.charAt(i);
			c = Encrypter.encrypt(c);
			b.append(c);
			
		}
		return b.toString();
	}
}
