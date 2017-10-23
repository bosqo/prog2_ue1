package uebung_1;

public class Rekursiv {
	
	public static void rekursiv(int i){
		i = i + i;
		System.out.println(i);
		
		if (i > 100) {
			return;
		}
		rekursiv(i);
	}
	
	/*public static void main(String[] args) {
		rekursiv(1);
	}
*/
}
