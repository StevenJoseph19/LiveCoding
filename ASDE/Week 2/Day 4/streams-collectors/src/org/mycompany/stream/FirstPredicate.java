package org.mycompany.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicate {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("One", "Two", "Three", "Four", "Five");

		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = Predicate.isEqual("Two");
		Predicate<String> p3 = Predicate.isEqual("Three");

		stream
//				.filter(p1)
				.filter(p2.or(p3))
				.forEach(s -> System.out.println(s));



		}

}
