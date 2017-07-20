package literatePrimes;

/**
 * 
 * @author kumaj04
 * The main
program is contained in the PrimePrinter class all by itself. Its responsibility is to handle
the execution environment. It will change if the method of invocation changes
 */
public class PrimePrinter {
	public static void main(String[] args) {
		final int NUMBER_OF_PRIMES = 1000;
		int[] primes = PrimeGenerator.generate(NUMBER_OF_PRIMES);
		final int ROWS_PER_PAGE = 50;
		final int COLUMNS_PER_PAGE = 4;
		RowColumnPagePrinter tablePrinter = new RowColumnPagePrinter(
				ROWS_PER_PAGE, COLUMNS_PER_PAGE, "The First "
						+ NUMBER_OF_PRIMES + " Prime Numbers");
		tablePrinter.print(primes);
	}
}
