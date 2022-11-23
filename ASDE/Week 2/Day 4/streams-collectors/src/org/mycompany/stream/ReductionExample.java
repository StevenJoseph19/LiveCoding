package org.mycompany.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String... args) {

//		List<Integer> list = Arrays.asList(10,10,10);
//		List<Integer> list = Arrays.asList(10,10);
//		List<Integer> list = Arrays.asList(10);
		List<Integer> list = Arrays.asList();
//		List<Integer> list = Arrays.asList(-10);
//		List<Integer> list = Arrays.asList(-10,10);
//        List<Integer> list = Arrays.asList(-10, -10);

//		Integer red =
//				list.stream()
//				.reduce(0, (i1,i2) -> i1 + i2);
//				.reduce(0, Integer::sum);
//						.reduce(100, Integer::sum);

        Optional<Integer> red =
                list.stream()
//						.reduce(0, Integer::max);
                        .reduce(Integer::max);

        System.out.println("red = " + red);


    }

}
