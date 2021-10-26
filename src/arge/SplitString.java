package arge;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SplitString {
	public static void main(String[] args) {
		String str = "88";

		int A[] = { 5, 2, 4, 6, 3, 7 };

		System.out.println(divideArray(A));

	}

	public static int solution(String s) {
		if (s.startsWith("0")) {
			throw new RuntimeException("0 not");
		} else {
			int max = 0;
			for (int i = 0; i < s.toCharArray().length; i++) {
				if (i + 1 < s.toCharArray().length) {
					if (Integer.parseInt(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1))) > max) {
						max = Integer.parseInt(String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1)));
					}
				}
			}

			return max;
		}
	}

	public static int solution2(String s) {
		
		s.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Arrays.stream(s.split("\\s++")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k,v)->
					System.out.println(v)
				);
		return 0;
	}

	public static int divideArray(int A[]) {

		int score = 0;
		for (int i = 1; i < A.length - 3; i++) {
			for (int j = i + 2; j < A.length - 1; j++) {
				score = score + A[i] + A[j];
			}
		}

		return score;
	}

}
