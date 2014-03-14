package com.test;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class GenericTypesExample8 {

	private int a = 1;
	private String b = "b";
	private List<BagOfPrimitives> list = new ArrayList<BagOfPrimitives>();

	{
		for (int i = 0; i < 5; i++) {
			list.add(new BagOfPrimitives());
		}
	}

	static class BagOfPrimitives {

		private int value1 = 1;
		private String value2 = "abc";
		private transient int value3 = 3;

		public BagOfPrimitives() {

		}

		@Override
		public String toString() {
			return "value1:" + this.value1 + ", value2:" + this.value2
					+ ", value3:" + this.value3;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gson gson = new Gson();
		System.out.println(gson.toJson(1));
		int[] values = { 1 };
		System.out.println(gson.toJson(values));
		int one = gson.fromJson("1", int.class);
		System.out.println(one);
		BagOfPrimitives obj = new BagOfPrimitives();
		String json = gson.toJson(obj);
		System.out.println(json);
		BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
		System.out.println(obj2.toString());
		System.out.println(gson.toJson(new GenericTypesExample8()));
	}

}
