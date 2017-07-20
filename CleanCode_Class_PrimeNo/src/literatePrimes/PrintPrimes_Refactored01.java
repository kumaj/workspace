package literatePrimes;

public class PrintPrimes_Refactored01 {

	final static int M = 1000;
	final static int RR = 50;
	final static int CC = 4;
	final static int WW = 10;
	final static int ORDMAX = 30;
	static int P[] = new int[M + 1];
	static int PAGENUMBER;
	static int PAGEOFFSET;
	static int ROWOFFSET;
	static int C;
	
	static int J = 1;
	static int K = 1;
	static boolean JPRIME;
	static int ORD = 2;
	static int SQUARE = 9;
	static int N;
	static int MULT[] = new int[ORDMAX + 1];
	//int P[1] = 2;
	
	/**
	 * Generate the prime no
	 */
	private static void generatePrimeNo() {
		while (K < M) {
			do {
				J = J + 2;
				if (J == SQUARE) {
					ORD = ORD + 1;
					SQUARE = P[ORD] * P[ORD];
					MULT[ORD - 1] = J;
				}
				N = 2;
				JPRIME = true;
				while (N < ORD && JPRIME) {
					while (MULT[N] < J)
						MULT[N] = MULT[N] + P[N] + P[N];
					if (MULT[N] == J)
						JPRIME = false;
					N = N + 1;
				}
			} while (!JPRIME);
			K = K + 1;
			P[K] = J;
			
		}
	}
	
	/**
	 * Print the page
	 */
	private static void PrintPage() {
		PAGENUMBER = 1;
		PAGEOFFSET = 1;
		while (PAGEOFFSET <= M) {
			System.out.println("The First " + M +
			" Prime Numbers --- Page " + PAGENUMBER);
			System.out.println("");
				for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++){
				for (C = 0; C < CC;C++)
				if (ROWOFFSET + C * RR <= M)
				System.out.format("%10d", P[ROWOFFSET + C * RR]);
				System.out.println("");
			}
			System.out.println("\f");
			PAGENUMBER = PAGENUMBER + 1;
			PAGEOFFSET = PAGEOFFSET + RR * CC;
		}
	}
	
	public static void main(String[] args) {
		generatePrimeNo();
		PrintPage();
	}
}
