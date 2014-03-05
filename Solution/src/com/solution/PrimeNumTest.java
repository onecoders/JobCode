package com.solution;

/**
 * Calculate Prime number after a specified number
 * 
 */

public class PrimeNumTest {

	public void calculate(int K) {
		K++;
		boolean isPrimeNum = false;
		for (int i = 2; i < K; i++) {
			if (K % i == 0) {
				isPrimeNum = true;
				break;
			}
		}
		if (isPrimeNum) {
			calculate(K);
		} else {
			System.out.println(K);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int K = 9949;
		new PrimeNumTest().calculate(K);
	}

}
