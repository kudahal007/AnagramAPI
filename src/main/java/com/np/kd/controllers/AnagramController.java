package com.np.kd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.np.kd.model.Response;
import com.np.kd.services.AnagramService;

@RestController
@RequestMapping("/anagrams")
public class AnagramController {
	
	private AnagramService anagramService;
	
	@Autowired
	public AnagramController(AnagramService anagramService) {
		this.anagramService=anagramService;
		
	}
	
	@RequestMapping("/{string1}/{string2}")
	public Response checkAnagram(@PathVariable String string1, @PathVariable String string2) {
		return anagramService.checkAnagram(string1,string2);
	}

}
