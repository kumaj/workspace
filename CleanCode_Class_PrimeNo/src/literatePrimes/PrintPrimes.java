package literatePrimes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PrintPrimes {
	
	public static void main(String[] args) {
		final int M = 1000;
		final int RR = 50;
		final int CC = 4;
		final int WW = 10;
		final int ORDMAX = 30;
		int P[] = new int[M + 1];
		int PAGENUMBER;
		int PAGEOFFSET;
		int ROWOFFSET;
		int C;
		
		int J;
		int K;
		boolean JPRIME;
		int ORD;
		int SQUARE;
		int N;
		int MULT[] = new int[ORDMAX + 1];
		J = 1;
		K = 1;
		P[1] = 2;
		ORD = 2;
		SQUARE = 9;
		
		while (K < M) {
			K++;
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
		PAGENUMBER = 1;
		PAGEOFFSET = 1;
		while (PAGEOFFSET <= M) {
			System.out.println(Messages.getString("PrintPrimes.0") + M + //$NON-NLS-1$
			Messages.getString("PrintPrimes.1") + PAGENUMBER); //$NON-NLS-1$
			System.out.println(Messages.getString("PrintPrimes.2")); //$NON-NLS-1$
				for (ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++){
				for (C = 0; C < CC;C++)
				if (ROWOFFSET + C * RR <= M)
				System.out.format(Messages.getString("PrintPrimes.3"), P[ROWOFFSET + C * RR]); //$NON-NLS-1$
				System.out.println(Messages.getString("PrintPrimes.4")); //$NON-NLS-1$
			}
			System.out.println(Messages.getString("PrintPrimes.5")); //$NON-NLS-1$
			PAGENUMBER = PAGENUMBER + 1;
			PAGEOFFSET = PAGEOFFSET + RR * CC;
		}
    }
}
