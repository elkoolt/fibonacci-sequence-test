package com.fibonacci.sequence;

import java.util.Map;

/**
 * Fibonacci sequence interface
 * 
 * @author Karolis
 *
 */
public interface Fibonacci {

	/**
	 * Fibonacci sequence generator
	 * 
	 * @param n
	 * @return
	 */
	int generator(int n);

	/**
	 * Fibonacci sequence runner
	 * 
	 * @param n
	 * @return
	 */
	Map<String, String> run(int n);
}
