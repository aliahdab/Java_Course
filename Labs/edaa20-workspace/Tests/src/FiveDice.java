

public class FiveDice {

	public static void main (String []args){
		
		Die[] dice = new Die[5];
		for (int i = 0;i < dice.length;i++) {
			dice[i] = new Die();
		}
		for (int i= 0; i < dice.length;i++) {
			dice[i].roll();
			System.out.println("Tärning pos "+ i + " Visar" + dice[i] + dice[i].getDots());
		
		
		}
		
		
//		int [] a = {7,8,9};
//		int [] b = Arrays.copyOf(a,3);
//		System.out.println(Arrays.toString(b));
		
	}
}
