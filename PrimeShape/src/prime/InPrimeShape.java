package prime;

import java.util.*;

public class InPrimeShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of primes.");
		int numPrimes = sc.nextInt();
		
		System.out.println("Values considered will be less than or equal to: ");
		int maxValue = sc.nextInt();
		
		System.out.println("Enter the primes to use.");
		
		int input = 1;
		ArrayList<Integer> primesWanted = new ArrayList<Integer>();
		
		for (int a = 0; a < numPrimes; a++) {
			input = sc.nextInt();
			primesWanted.add(input);
		}
		
		System.out.println(primesWanted);
		
		ArrayList<Integer> primesUnwanted = new ArrayList<Integer>();
		
		int counter = 0;
		
		for (int a = 2; a <= maxValue; a++) {
			for (int b = 2; b <= a; b++) {
				if (a % b == 0 && a != b) {
					counter++;
				}
			}
			if (counter == 0)
				primesUnwanted.add(a);
			counter = 0;
		}
		
		System.out.println(primesUnwanted);
		
		primesUnwanted.removeAll(primesWanted);
		
		System.out.println(primesUnwanted);
		
		//Must find a limit for the exponents of the primes
		int limitExponent = 0;
		
		while ((int)(Math.pow(primesWanted.get(0), limitExponent)) < maxValue) {
			limitExponent++;
		}
		
		System.out.println("The value of the limiting exponent is: " + limitExponent);
		
		/*
		 * Check whether any of the numbers in the range are divisible by a power of
		 * the primes wanted and if they are divisible by a power of the primes unwanted
		 */
		
		ArrayList <Integer> potentialPDiv = new ArrayList <Integer>();
		int counter1 = 0;
		
		for (int a = 1; a <= maxValue; a++) {
			for (int x = 1; x <= limitExponent; x++) {
				for (int index = 0; index < primesWanted.size(); index++) {
					if ((a % (int)(Math.pow(primesWanted.get(index), x)) == 0) || (a == 1)) {
						counter1++;
					}
				}
			}
			if (counter1 != 0) {
				potentialPDiv.add(a);
			}
			counter1 = 0;
		}
		
		System.out.println(potentialPDiv);
		
		ArrayList <Integer> fakePDiv = new ArrayList <Integer>();
		int counter2 = 0;
		
		for (int a = 1; a <= maxValue; a++) {
			for (int x = 1; x <= limitExponent; x++) {
				for (int index = 0; index < primesUnwanted.size(); index++) {
					if ((a % (int)(Math.pow(primesUnwanted.get(index), x)) == 0)) {
						counter2++;
					}
				}
			}
			if (counter2 != 0) {
				fakePDiv.add(a);
			}
			counter2 = 0;
		}
		
		System.out.println(fakePDiv);
		
		potentialPDiv.removeAll(fakePDiv);
		
		System.out.println(potentialPDiv);
		
		System.out.println("The number of real P-prime numbers is: " 
		+ potentialPDiv.size());
		
		sc.close();
	}

}

