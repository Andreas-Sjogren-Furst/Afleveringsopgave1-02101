import java.util.Random;

public class PredatorPray {
public static final Random rand = new Random();
	
	public static void main(String[] args) {
		runSimulation(20, 2, 10);
	}
	
	public static void runSimulation(int n, int s, int t) {
		
		printParameters(n,s,t);
		
		if (n > 0 && s > 0 && t >=0) {
			int[] pray = new int[2];
			int[] predator = new int[2];
			beginSimulation(pray, predator, n);
			
			for (int i = 1; i<=t;i++) {
				movePray(pray,n,s);
				movePredator(predator,pray,s,n);
				if (checkForCatch(pray,predator) == true) {
					printPositionPrayPredator(pray,predator);
					System.out.println("Catch!");
					break;
				} else printPositionPrayPredator(pray, predator);
			}
		} else System.out.println("Illegal Parameters!");
	}
	
	public static void beginSimulation(int[] pray, int[] predator, int n) {
		createRandomPos(pray,n);
		createRandomPos(predator,n);
		printPositionPrayPredator(pray, predator);
	}
	
	public static int[] createRandomPos(int pray[],int n) {
		pray[0] = rand.nextInt(n);
		pray[1] = rand.nextInt(n);
		return pray;
	}
	
	
	public static void movePray(int currentPrayPosition[], int n, int s){
		
		int[] moveValueX_Y = new int[2];
		moveValueX_Y[0] = rand.nextInt((s*2)+1)-s;
		moveValueX_Y[1] = rand.nextInt((s*2)+1)-s;
		
		for(int i = 0; i < 2;i++) {
			if((currentPrayPosition[i] + moveValueX_Y[i]) < 0) {
				currentPrayPosition[i] = 0;
			}
			
			else if ((currentPrayPosition[i] + moveValueX_Y[i]) > (n-1)) {
				currentPrayPosition[i] = n-1;
			}
			
			else {
				currentPrayPosition[i] += moveValueX_Y[i];
			}
		} 
	}
	
	public static void movePredator(int currentPredatorPosition[], int currentPrayPosition[],int s, int n) {
		
		for (int i=0;i<2;i++) {
			if(currentPrayPosition[i] < currentPredatorPosition[i]) {
				if((currentPredatorPosition[i] - s) < currentPrayPosition[i]) {
					currentPredatorPosition[i] = currentPrayPosition[i];
				} else currentPredatorPosition[i] -= s;
			}
			else {
				if((currentPredatorPosition[i] + s) > currentPrayPosition[i]) {
					currentPredatorPosition[i] = currentPrayPosition[i];
				} else currentPredatorPosition[i] += s;
			} 
		}
	}
	
	public static void printPositionPrayPredator(int prayPos[], int predatorPos[]) {
		System.out.printf("[%d;%d] [%d;%d]\n",prayPos[0],prayPos[1],predatorPos[0],predatorPos[1]);
	}
	
	public static boolean checkForCatch(int prayPos[],int predatorPos[]) {
		for (int i=0; i<2;i++) {
			if(prayPos[i] != predatorPos[i]) {
				return false;
			}
		} return true;
	}
	
	public static void printParameters(int n, int s, int t) {
		System.out.printf("n=%d s=%d t=%d\n",n,s,t);
	}
}
