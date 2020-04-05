public class test3 {

	public static void main(String[] args) {
		int[] a = { 6, 8, 9, -10,- 12 };
		int sum=0;
		for(int n : a) {
			if (n>0) {
				sum=sum+n;
			}
			
		}
		System.out.println(sum);
	}
}