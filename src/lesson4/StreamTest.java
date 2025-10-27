package lesson4;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Integer> stream = Arrays.asList(1,2,3).stream();

		/*
		 * Stream<Integer> stream = Arrays.asList(1,2,3).stream();
		 * 
		 * Stream<Integer> stream1 = stream.filter( new Predicate<Integer>() {
		 * 
		 * @Override public boolean test(Integer t) { // TODO Auto-generated method stub
		 * return t > 1; }
		 * 
		 * });
		 * 
		 * // stream1.forEach((c)->System.err.println(c));
		 * System.err.println("count="+stream1.count());
		 */
		
		Arrays.asList(1,2,3).stream()
			.filter((x)->x > 1)
			.forEach((s)->System.err.println(s));
		
		
		System.err.println(
			Arrays.toString(
				Arrays.asList("Ivanov,10","Petrov,20","Sidorov,30")
					.stream()
					.map((x)->x.split(","))
					.sorted((x1,x2)->Integer.valueOf(x1[1])-Integer.valueOf(x2[1]))
					.findFirst().get()
			)
		);
		
	}

}
