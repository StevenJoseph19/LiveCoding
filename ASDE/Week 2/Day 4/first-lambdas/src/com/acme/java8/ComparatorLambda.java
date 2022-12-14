package com.acme.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

/**
 * @author steve
 *
 */
public class ComparatorLambda {

	public static void main(String... args) {

		
//		  Comparator<String> comp = new Comparator<String>() {
//
//		  @Override
//		  public int compare(String s1, String s2) { return
//		  Integer.compare(s1.length(), s2.length());
//
//		  } };

		Comparator<String> compLambda = (String s1, String s2) ->

				Integer.compare(s1.length(), s2.length());


		List<String> list = Arrays.asList("***", "**", "****", "*");
//		Collections.sort(list, comp);
		Collections.sort(list, compLambda);

		for (String s : list) {
			System.out.println(s);
		}

	}

}
