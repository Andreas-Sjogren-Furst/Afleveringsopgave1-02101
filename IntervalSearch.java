package hjem1;

public class IntervalSearch {

	public static boolean intervalContains(int g1, int g2, int b) {
		for(int i = 1; i <= g2; i++) { //foor-loop for eksponenten, i, som modtager værdien fra 1 op til g2.
			if(g1 <= Math.pow(b, i) && Math.pow(b, i) <= g2 || 
					g2 <= Math.pow(b, i) && Math.pow(b, i) <= g1) //if-statement som checker om vores potens b ligger
				return true;								//mellem g1 og g2 eller g2 og g1, returner true hvis muligt.
		}
		return false; //Hvis ikke returnes boolean-værdien false.
	}
}
