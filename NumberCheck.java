package hjem1;

public class NumberCheck {

	public static boolean check(String number) {
		int sum = 0; //holder værdien for cross-value
		for(int i = number.length()-1; i >= 0; i--) { //Foor-loop starter med det bagerste index og bevæger sig mod 0.
			int n = Character.getNumericValue(number.charAt(i)); //Gemmer char-typen som integer
			if((number.length() - i) % 2 == 1) { //Checker om vi er på et lige index.
				sum += n;
			}
			else {
				if(n * 2 < 10) {
					sum += n * 2;
				}
				else {
					sum += (n * 2) % 10 + 1;
				}
			}
		}
		return (sum % 10 == 0); //returner boolean value om cross-value%10 er lig med 0
	}
}
