package com.fibonacci.services;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fibonacci.sequence.FibonacciSequence;

/**
 * Fibonacci Service class
 * 
 * @author Karolis
 *
 */
@Controller
public class FibonacciController {

	/**
	 * Getter for Fibonacci sequence
	 * 
	 * @param n
	 * @return
	 */
	@GetMapping("/run")
	@ResponseBody
	public Map<String, String> fibonacci(@RequestParam(name = "n", required = true, defaultValue = "0") int n) {
		FibonacciSequence fib = new FibonacciSequence();

		if (n < 0)
			return Collections.singletonMap("error", "Negative number is forbidden!");
		
		return fib.run(n);
	}
}
