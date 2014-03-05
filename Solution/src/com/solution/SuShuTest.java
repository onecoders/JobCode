package com.solution;

/**
 * Class Description goes here.
 * 
 */

public class SuShuTest {

	public void calculate(int K) {
		K++;
		boolean isSuShu = false;
		for (int i = 2; i < K; i++) {
			if (K % i == 0) {
				isSuShu = true;
				break;
			}
		}
		if (isSuShu) {
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
		new SuShuTest().calculate(K);
	}

}
