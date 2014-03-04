package com.solution;

public class LoopTest {

	private int[] array;
	private int length = 10000000;

	{
		System.out.println("初始化");
		array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = i;
		}
		System.out.println("初始化完毕");
	}

	public String loop1() {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			// System.out.println(array[i]);
		}
		long end = System.currentTimeMillis();
		return "loop1:" + (end - begin);
	}

	public String loop2() {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			// System.out.println(array[i]);
		}
		long end = System.currentTimeMillis();
		return "loop2:" + (end - begin);
	}

	public String loop3() {
		long begin = System.currentTimeMillis();
		for (int i : array) {
			// System.out.println(i);
		}
		long end = System.currentTimeMillis();
		return "loop3:" + (end - begin);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoopTest test = new LoopTest();
		System.out.println(test.loop1());
		System.out.println(test.loop2());
		System.out.println(test.loop3());
	}

}
