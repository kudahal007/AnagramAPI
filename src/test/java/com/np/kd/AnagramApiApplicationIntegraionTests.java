package com.np.kd;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.np.kd.services.AnagramService;

@AutoConfigureMockMvc
@SpringBootTest
class AnagramApiApplicationIntegraionTests {
	@Autowired
	private MockMvc mockMvc;


	@Autowired
	AnagramService anagramService;
	
	@Test
	public void checkAnagram_validAnagrams() throws Exception {

		String[][] input = { 
				{"apple", "elppa", "true"},
				{ "cat", "tac", "true" },
				{ "apple ball", "a p ppp l e l l a b", "false" } };

		RequestBuilder requestBuilder;
		for (String[] str : input) {
			requestBuilder = get("/anagrams/{string1}/{string2}", str[0], str[1]).accept(MediaType.APPLICATION_JSON);
			mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print())
					.andExpect(jsonPath("$.areAnagram", is(Boolean.valueOf(str[2]))));
		}
	}


	@Test
	public void checkAnagram_NotFound() throws Exception {
		String[][] input = { {null, null},{"", ""}, {"", " "}, {" ", ""}, {"/", "/"} };
		
		RequestBuilder requestBuilder;
		for (String[] str : input) {
			requestBuilder = get("/anagrams/{string1}/{string2}", str[0], str[1]).accept(MediaType.APPLICATION_JSON);
			mockMvc.perform(requestBuilder).andExpect(status().isNotFound());
		}
	}
}
