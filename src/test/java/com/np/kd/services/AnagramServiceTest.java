package com.np.kd.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.np.kd.services.AnagramService;

@SpringBootTest
public class AnagramServiceTest {
	
	@Autowired
	AnagramService anagramService;
	
	@Test
	public void checkAnagramTest() {
		String[][] input = { { "cat", "tac" }, 
				{"Debit card", "Bad credit"},
				{"Hamlet", "Amleth"},
				{"Hello", "Hellooooo"}};
		boolean[] expected = { true, true, true, false };
		for (int i = 0; i < input.length; i++) {
			 assertEquals(expected[i], anagramService.check(input[i][0], input[i][1]));
		}
	}

}
