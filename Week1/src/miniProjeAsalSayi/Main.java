package miniProjeAsalSayi;

public class Main {
	
	public static void main (String [] args) {
		int number = -2;
		int reminder = number % 2;
		
		System.out.println(reminder);
		boolean isPrime = true;
		
		if (number == 1) {
			System.out.println("Sayı Asal Değildir");
			return;
		}
		
		if (number < 1) {
			System.out.println("Geçersiz Sayı");
		}
		
		for(int i = 2;	i < number; i++) {
			if(number % i == 2) {
				isPrime = false;
			}
		}
		
		if(isPrime == true) {
			System.out.println("Sayı asaldır");
		} else {
			System.out.println("Sayı asal Değildir");
		}
	}

}
