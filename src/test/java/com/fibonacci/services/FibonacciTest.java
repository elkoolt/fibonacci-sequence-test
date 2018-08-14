package com.fibonacci.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Fibonacci Sequence tests
 * 
 * @author Karolis
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class FibonacciTest {

	private static final String SEQUENCE_5 = "{\"0\":\"0\",\"1\":\"1\",\"2\":\"1\",\"3\":\"2\",\"4\":\"3\",\"5\":\"5\"}";
	private static final String SEQUENCE_0 = "{\"0\":\"0\"}";
	private static final String ERROR = "{\"error\":\"Negative number is forbidden!\"}";

	private MockMvc mockMvc;

	@InjectMocks
	private FibonacciController fibonacciController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(fibonacciController).build();
	}

	/**
	 * Test should return sequence containing 5 values
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldReturnSequenceFive() throws Exception {

		this.mockMvc
				.perform(get("/run?n=5").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().string(containsString(SEQUENCE_5)));
	}

	/**
	 * Run test many times
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldRunSequenceManyTimes() throws Exception {
		for (int i = 0; i < 10000; i++) {
			shouldReturnSequenceFive();
		}

	}

	/**
	 * Test should return sequence containing 1 value
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldReturnSequenceZero() throws Exception {

		this.mockMvc
				.perform(get("/run?n=0").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(content().string(containsString(SEQUENCE_0)));
	}

	/**
	 * Test should return error message
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldReturnError() throws Exception {

		this.mockMvc
				.perform(get("/run?n=-1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo(ERROR)));
	}
}
