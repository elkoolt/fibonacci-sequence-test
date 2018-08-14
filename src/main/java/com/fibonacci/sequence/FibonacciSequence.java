package com.fibonacci.sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci Sequence generator
 * 
 * @author Karolis
 *
 */
public class FibonacciSequence implements Fibonacci {

	@Override
	public int generator(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			return generator(n - 1) + generator(n - 2);
		}
	}

	@Override
	public Map<String, String> run(int n) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <= n; i++) {
			map.put(String.valueOf(i), String.valueOf(generator(i)));
		}
		return map;
	}
}
